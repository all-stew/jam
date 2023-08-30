package com.zhaojj11.jam.albion.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaojj11
 */
@Getter
@Setter
@TableName(value = "items", autoResultMap = true)
public class Item {

    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String uniqueName;
    private String name;
    private String description;
    private long createdBy;
    private LocalDateTime createdTime;
    private long updatedBy;
    private LocalDateTime updatedTime;
}
