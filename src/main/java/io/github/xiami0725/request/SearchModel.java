package io.github.xiami0725.request;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.*;

/**
 * @author lzz
 * @create 2021-04-22 16:14
 */

public class SearchModel<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private List<Field> fields;
    private String orderField;
    private boolean isAsc;

    public IPage<T> getPage() {
        IPage<T> page = new Page<>(pageIndex, pageSize);
        if (StringUtils.isNotBlank(orderField)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(isAsc);
            orderItem.setColumn(orderField);
            page.orders().add(orderItem);
        }
        return page;

    }

    public Map<String, Object> getFieldMap() {
        Map<String, Object> map = new HashMap<>();
        if (this.getFields() != null) {
            for (Iterator iter = this.fields.iterator(); iter.hasNext(); ) {
                Field field = (Field) iter.next();
                if (null != field.getValue()) {

                    map.put(field.getName(), field.getValue());
                }

            }
        }

        return map;

    }


    public QueryWrapper<T> getQueryModel() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (this.getFields() != null) {
            for (Iterator iter = this.fields.iterator(); iter.hasNext(); ) {
                Field field = (Field) iter.next();
                switch (field.getQueryMethod()) {
                    case eq:
                        if (null != field.getValue()) {
                            queryWrapper.eq(true, field.getName(), field.getValue());
                        }
                        break;
                    case like:
                        if (null != field.getValue()) {
                            queryWrapper.like(true, field.getName(), field.getValue());
                        }
                        break;

                    default:
                        break;

                }
            }
        }

        if (StringUtils.isNotBlank(orderField)) {
            queryWrapper.orderBy(true, isAsc, orderField);
        }
        return queryWrapper;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }
}
