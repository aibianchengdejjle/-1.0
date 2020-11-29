package com.jjle.sport.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubMenu {
    private int id;
    private String title;
    private String path;
}
