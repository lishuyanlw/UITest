package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandResponse {
    public String Name;
    public String DimensionId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDimensionId() {
        return DimensionId;
    }

    public void setDimensionId(String dimensionId) {
        DimensionId = dimensionId;
    }
}
