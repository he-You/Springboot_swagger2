package com.example.swagger2.entity.ResponseInfo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * 简要说明. <br>
 * 返回体信息
 * <p>
 * Date-Time：  2019/9/16 10:46
 * <p>
 *
 * @author heyou
 * @version 1.0.0
 */
@Data
public class Result implements Serializable {
    //标志位
    private boolean success;

    private String code;
    //返回信息
    private String msg;
    //数据集
    private Object data;
    private PageData page;
    public Result() {
        this.success = false;
    }
    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    public Result setInfo(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.setData(data);
        return this;
    }

    public void setData(Object data) {
        if(data instanceof PageInfo<?>) {
            PageInfo<?> pageInfo = (PageInfo<?>)data;
            this.page = new PageData(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getPages(),pageInfo.getTotal());
            this.data = pageInfo.getList();
        }else {
            this.data = data;
        }
    }
    public void setPageInfo(PageInfo<?> pageInfo) {
        this.page = new PageData(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getPages(),pageInfo.getTotal());
    }
}
