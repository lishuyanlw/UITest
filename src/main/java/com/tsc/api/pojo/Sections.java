package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sections {
    public Sections(){}

    public String Name;
    public int Order;
    public List<Contents> Contents;

    public String getName() {        return Name;    }

    public void setName(String name) {        Name = name;    }

    public int getOrder() {        return Order;    }

    public void setOrder(int order) {        Order = order;    }

    public List<Sections.Contents> getContents() {        return Contents;    }

    public void setContents(List<Sections.Contents> contents) {        Contents = contents;    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Contents{
        public int ContentOrder;
        public String Content;

        public int getContentOrder() {            return ContentOrder;        }

        public void setContentOrder(int contentOrder) {            ContentOrder = contentOrder;        }

        public String getContent() {            return Content;        }

        public void setContent(String content) {            Content = content;        }
    }
}
