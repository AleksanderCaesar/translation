package yan.algernon.utils;

import yan.algernon.domain.TextForTranslate;

import static org.junit.Assert.*;

public class ConnectorTest {

    @org.junit.Test
    public void sendToApiTest()
    {
        TextForTranslate txt = new TextForTranslate("en","ru","Hello");
        assertEquals("{ \"translations\": [  {   \"text\": \"Привет\"  } ]}", Connector.sendToApi(txt));
        TextForTranslate txt2 = new TextForTranslate("ru","en","Привет");
        assertEquals("{ \"translations\": [  {   \"text\": \"Hi\"  } ]}", Connector.sendToApi(txt2));
    }
}