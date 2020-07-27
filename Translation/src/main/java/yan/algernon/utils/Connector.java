package yan.algernon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import yan.algernon.domain.TextForTranslate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Connector
{    private static Logger errorLogger;

    public static String sendToApi(TextForTranslate textForTranslate)  {
        errorLogger = LogManager.getLogger("errors");
        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";
        URL obj = null;
        try {
            obj = new URL(url);
        } catch (MalformedURLException e) {
            errorLogger.error(e.getMessage());
        }
        HttpsURLConnection con = null;
        try {
            con = (HttpsURLConnection) obj.openConnection();
        } catch (IOException e) {
            errorLogger.error(e.getMessage());
        }
        String authKey = "Bearer CggVAgAAABoBMxKABBrE3TaStu-64qaJHKgZdoQ_HSdTc1AMQPXOu9gtO2fFfLO1s_k7z_hbTApAOd_jysObLbSW5KPJAksA5-pHGMZ3StrnGUDT1a4A7W4VBFUkLHGyQVr2NLhQn5z1-zDs7wK7thed7Xu-3zvYarnIyyTUwqYYbA80EqI5c6xc2-Hlg4FuhqHWzIjmVndKuwiOAMclHpI6mZznch85W7Jd3oDAevVjCOmHHyVPGF4WFcbNMKEK7ZoDeL0kCAjN-krPycucdvOdMqykTX0qp_GPLwqjGEDqHDXNR_106Zxo3A4VFUio72DdfyEv6M7o6s1bip5ygWLdWkrEmSusJ67gwS5F6xbVOVjmqOa_KI_CuMizfEcLgSTqlrQK-qhSft1JiB1FI18X3zI4Tx34_GFRNdUNZQa0I1kM5GqC5UU9vCibatZwwJY6egR1p38R4Fz2RDqk4eTWtWBIvxScLu4Z5CI7b66o4Q2Vrd22tmZM86lxdQ4ro-Yf2eAfs7_8pkJBuzZLFjHFGzxRfPYfYl-WtNlVr016gvE9NDEqgU_4pUbhXETlF-LBktIGWm2JNFql3HTdlcKYFIhlW94Z9wW7reJOsXUMv60agkPRZ86hi5nfLgSXWsGGBM4GR64ru50Doo6U5pMc2Meja1zdsSFJCboeG2CI_rQADodgRVCDNN18GiQQ3Lj5-AUYnIr8-AUiFgoUYWplN2wxYW41Y3NraHJvdnFtY2o=";

        String USER_AGENT = "PostmanRuntime/7.26.2";
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            errorLogger.error(e.getMessage());
        }
        con.setRequestProperty ("Authorization", authKey);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");


        ObjectMapper mapper = new ObjectMapper();
        String forTranslate = null;
        try {
            forTranslate = mapper.writeValueAsString(textForTranslate);
        } catch (JsonProcessingException e) {
            errorLogger.error(e.getMessage());
        }

        con.setDoOutput(true);
        StringBuffer response = new StringBuffer();
        try {
            con.getOutputStream().write(forTranslate.getBytes());

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (IOException e){
            errorLogger.error(e.getMessage());
        }
        //print result
        return response.toString();
    }
}
