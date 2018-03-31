package cn.jbone.tag.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 0:25
 */
@Data
public class UpdateTagModel extends CreateTagModel implements Serializable {
    private int id;
}
