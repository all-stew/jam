package com.zhaojj11.jam.libs.jpa.utils;

import static com.zhaojj11.jam.protobuf.common.v1.Sort.SORT_DESC;

import com.zhaojj11.jam.protobuf.common.v1.Pagination;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.CollectionUtils;

public final class PageUtils {

    private PageUtils() {
    }

    /**
     * 获取分页参数.
     *
     * @param pagination proto 的分页信息
     * @return jpa支持的分页信息
     */
    public static PageRequest getPage(final Pagination pagination) {
        Sort.Direction direction = Direction.ASC;
        if (SORT_DESC == pagination.getSort()) {
            direction = Direction.DESC;
        }

        Sort sort;
        if (CollectionUtils.isEmpty(pagination.getPropertiesList())) {
            sort = Sort.by(direction);
        } else {
            sort = Sort.by(direction, pagination.getPropertiesList().toArray(new String[0]));
        }

        return PageRequest.of(pagination.getCurPage(), pagination.getPerPage(), sort);
    }
}
