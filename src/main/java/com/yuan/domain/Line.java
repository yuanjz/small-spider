package com.yuan.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 15:12
 * @Description:
 */
@Data
@NoArgsConstructor
public class Line {

    private String lineId;

    private String sourceNodeId;

    private String targetNodeId;

    public Line(String sourceNodeId, String targetNodeId) {
        this.sourceNodeId = sourceNodeId;
        this.targetNodeId = targetNodeId;
        this.lineId = sourceNodeId + "-" + targetNodeId;
    }
}
