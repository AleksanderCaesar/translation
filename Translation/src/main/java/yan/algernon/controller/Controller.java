package yan.algernon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yan.algernon.domain.*;
import yan.algernon.service.HistoryService;
import yan.algernon.utils.Connector;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller
{
    private Logger logger;
    @Autowired
    private HistoryService historyService;


    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("fromLang", Languages.values());
        model.addAttribute("toLang", Languages.values());
        return "index";
    }

    @PostMapping("/")
    public String translate(@RequestParam(required = false) String textToTranslate,@RequestParam(name ="fromLang" ,required = false) Languages fromLang,
                            @RequestParam(required = false) Languages toLang,   Model model)  throws Exception
    {
        model.addAttribute("fromLang", Languages.values());
        model.addAttribute("toLang", Languages.values());




        String[] subStr = textToTranslate.split(" ");
        List<Wrapper> wrappers = new ArrayList<>();
        for(String txt : subStr) {
            TextForTranslate textForTranslate = new TextForTranslate(fromLang.toString(), toLang.toString(), txt);
            TranslateHistory history = new TranslateHistory();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            history.setRequestIp(hostAddress);
            history.setRequestDate(new Date());
            history.setFromLang(textForTranslate.getTexts());

            ObjectMapper mapper = new ObjectMapper();
            String answer = Connector.sendToApi(textForTranslate);

            TransletedText transletedText = mapper.readValue(answer, TransletedText.class);
            history.setToLang(transletedText.getTranslations().get(0).getText());

            historyService.addHistory(history);
            wrappers.add(transletedText.getTranslations().get(0));
        }
        model.addAttribute("traslations", wrappers);

        return "index";
    }

}
