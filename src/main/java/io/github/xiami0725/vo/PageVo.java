package io.github.xiami0725.vo;

import java.util.List;

/**
 * @BelongsProject: tool
 * @BelongsPackage: io.github.xiami0725.vo
 * @Author: lizeze
 * @CreateTime: 2021-08-09 22:24
 */
public class PageVo<T> {

    private List<T> records;
    private long total;

    public List<T> getRecords() {
        return records;
    }

    public PageVo() {
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
