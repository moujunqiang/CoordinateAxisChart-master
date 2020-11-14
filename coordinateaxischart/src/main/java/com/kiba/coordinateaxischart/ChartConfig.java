package com.kiba.coordinateaxischart;


/**
 * 图表配置类
 */
public class ChartConfig {

    private Integer axisWidth;

    private Integer max;

    private Integer precision;

    private Integer segmentSize;

    private Integer axisColor;

    private Integer axisPointRadius;

    public Integer getAxisWidth() {
        return axisWidth;
    }

    public void setAxisWidth(Integer axisWidth) {
        this.axisWidth = axisWidth;
    }

    public Integer getMax() {
        return max;
    }

    /**
     * @param max axis max value
     */
    public void setMax(Integer max) {
        this.max = max;
    }


    public Integer getPrecision() {
        return precision;
    }

    /**
     * 函数曲线的精度，这个精度用于计算两点间切线的交点。推荐值：1-10<br>
     * @param precision precision of the function curve
     */
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getSegmentSize() {
        return segmentSize;
    }

    /**
     * 将x轴分割成segmentSize个点，成像时会将这些点连接起来。<br>
     * 注：size并不是越大越好，根据不同函数可做不同的调整（推荐值在30-100之间），尤其是tan和cot函数（目前尚未做优化）。<br>

     * @param segmentSize segment size
     */
    public void setSegmentSize(Integer segmentSize) {
        this.segmentSize = segmentSize;
    }

    public Integer getAxisColor() {
        return axisColor;
    }

    public void setAxisColor(Integer axisColor) {
        this.axisColor = axisColor;
    }

    public Integer getAxisPointRadius() {
        return axisPointRadius;
    }

    public void setAxisPointRadius(Integer axisPointRadius) {
        this.axisPointRadius = axisPointRadius;
    }
}
