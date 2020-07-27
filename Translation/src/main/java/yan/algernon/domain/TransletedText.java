package yan.algernon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class TransletedText
{
    @JsonIgnore
    private Integer id;
    @JsonProperty
    private List<Wrapper> translations;

    public TransletedText() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Wrapper> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Wrapper> translations) {
        this.translations = translations;
    }
}
