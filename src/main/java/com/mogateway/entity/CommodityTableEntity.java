package com.mogateway.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/31.
 */
@Entity
@Table(name = "commodity_table", schema = "shengdaojia", catalog = "")
public class CommodityTableEntity {
    private String numId;
    private String title;
    private String pictUrl;
    private String smallImages;
    private String reservePrice;
    private String zkFinalPrice;
    private String userType;
    private String provcity;
    private String itemUrl;
    private String nick;
    private String sellerId;
    private String volume;
    private String creatTime;
    private String popularity;
    private String voucherAddress;
    private String creatUser;

    @Id
    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "pict_url")
    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    @Basic
    @Column(name = "small_images")
    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    @Basic
    @Column(name = "reserve_price")
    public String getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(String reservePrice) {
        this.reservePrice = reservePrice;
    }

    @Basic
    @Column(name = "zk_final_price")
    public String getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(String zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "provcity")
    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    @Basic
    @Column(name = "item_url")
    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    @Basic
    @Column(name = "nick")
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "seller_id")
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "volume")
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "creat_time")
    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Basic
    @Column(name = "popularity")
    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "voucher_address")
    public String getVoucherAddress() {
        return voucherAddress;
    }

    public void setVoucherAddress(String voucherAddress) {
        this.voucherAddress = voucherAddress;
    }

    @Basic
    @Column(name = "creat_user")
    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommodityTableEntity that = (CommodityTableEntity) o;

        if (numId != null ? !numId.equals(that.numId) : that.numId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (pictUrl != null ? !pictUrl.equals(that.pictUrl) : that.pictUrl != null) return false;
        if (smallImages != null ? !smallImages.equals(that.smallImages) : that.smallImages != null) return false;
        if (reservePrice != null ? !reservePrice.equals(that.reservePrice) : that.reservePrice != null) return false;
        if (zkFinalPrice != null ? !zkFinalPrice.equals(that.zkFinalPrice) : that.zkFinalPrice != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (provcity != null ? !provcity.equals(that.provcity) : that.provcity != null) return false;
        if (itemUrl != null ? !itemUrl.equals(that.itemUrl) : that.itemUrl != null) return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        if (sellerId != null ? !sellerId.equals(that.sellerId) : that.sellerId != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (creatTime != null ? !creatTime.equals(that.creatTime) : that.creatTime != null) return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null) return false;
        if (voucherAddress != null ? !voucherAddress.equals(that.voucherAddress) : that.voucherAddress != null)
            return false;
        if (creatUser != null ? !creatUser.equals(that.creatUser) : that.creatUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numId != null ? numId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (pictUrl != null ? pictUrl.hashCode() : 0);
        result = 31 * result + (smallImages != null ? smallImages.hashCode() : 0);
        result = 31 * result + (reservePrice != null ? reservePrice.hashCode() : 0);
        result = 31 * result + (zkFinalPrice != null ? zkFinalPrice.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (provcity != null ? provcity.hashCode() : 0);
        result = 31 * result + (itemUrl != null ? itemUrl.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (sellerId != null ? sellerId.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (voucherAddress != null ? voucherAddress.hashCode() : 0);
        result = 31 * result + (creatUser != null ? creatUser.hashCode() : 0);
        return result;
    }
}
