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
@TableName(value = "prices", autoResultMap = true)
public class Price {

    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private long itemId;
    private long cityId;

    private long sellPriceMin;
    private LocalDateTime sellPriceMinDateTime;
    private long sellPriceMax;
    private LocalDateTime sellPriceMaxDateTime;
    private long buyPriceMin;
    private LocalDateTime buyPriceMinDateTime;
    private long buyPriceMax;
    private LocalDateTime buyPriceMaxDateTime;

    private long createdBy;
    private LocalDateTime createdTime;
    private long updatedBy;
    private LocalDateTime updatedTime;
}
