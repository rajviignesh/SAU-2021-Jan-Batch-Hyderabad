package com.accolite.test.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int itemId;
    private String itemName;
    private String itemCategory;
    private String itemQuantity;

    @JsonIgnore
    public boolean isEmpty(){
        if(this.itemName == null && this.itemCategory == null && this.itemQuantity == null) return true;
        return false;
    }

}
