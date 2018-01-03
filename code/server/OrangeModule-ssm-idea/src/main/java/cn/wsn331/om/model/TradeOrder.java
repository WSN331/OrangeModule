package cn.wsn331.om.model;

import java.util.Date;

public class TradeOrder extends Entity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_CODE
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_USER_ID
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_ADDRESS
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_RECEIVE
     *
     * @mbggenerated
     */
    private Integer receive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_trade_order.C_PRICE
     *
     * @mbggenerated
     */
    private Float price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_ID
     *
     * @return the value of t_trade_order.C_ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_ID
     *
     * @param id the value for t_trade_order.C_ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_CODE
     *
     * @return the value of t_trade_order.C_CODE
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_CODE
     *
     * @param code the value for t_trade_order.C_CODE
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_USER_ID
     *
     * @return the value of t_trade_order.C_USER_ID
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_USER_ID
     *
     * @param userId the value for t_trade_order.C_USER_ID
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_ADDRESS
     *
     * @return the value of t_trade_order.C_ADDRESS
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_ADDRESS
     *
     * @param address the value for t_trade_order.C_ADDRESS
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_CREATE_TIME
     *
     * @return the value of t_trade_order.C_CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_CREATE_TIME
     *
     * @param createTime the value for t_trade_order.C_CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_RECEIVE
     *
     * @return the value of t_trade_order.C_RECEIVE
     *
     * @mbggenerated
     */
    public Integer getReceive() {
        return receive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_RECEIVE
     *
     * @param receive the value for t_trade_order.C_RECEIVE
     *
     * @mbggenerated
     */
    public void setReceive(Integer receive) {
        this.receive = receive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_trade_order.C_PRICE
     *
     * @return the value of t_trade_order.C_PRICE
     *
     * @mbggenerated
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_trade_order.C_PRICE
     *
     * @param price the value for t_trade_order.C_PRICE
     *
     * @mbggenerated
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", userId=").append(userId);
        sb.append(", address=").append(address);
        sb.append(", createTime=").append(createTime);
        sb.append(", receive=").append(receive);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}