package yan.algernon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yan.algernon.domain.TranslateHistory;
import yan.algernon.repository.HistoryRepo;

@Service
public class HistoryService
{
    @Autowired
    private HistoryRepo historyRepo;

    public void addHistory(TranslateHistory history)
    {
     historyRepo.save(history);
    }
}
