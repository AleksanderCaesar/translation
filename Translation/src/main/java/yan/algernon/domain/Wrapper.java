package yan.algernon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Wrapper
{

    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private TransletedText translatedTextId;
    private String text;

    public Wrapper() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "text='" + text + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransletedText getTranslatedTextId() {
        return translatedTextId;
    }

    public void setTranslatedTextId(TransletedText translatedTextId) {
        this.translatedTextId = translatedTextId;
    }
}
