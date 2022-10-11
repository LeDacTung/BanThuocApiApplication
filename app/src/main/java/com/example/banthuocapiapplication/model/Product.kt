package com.example.banthuocapiapplication.model

data class Product(
    val IdSanPham: Int,
    val TenSanPham: String,
    val SoLuong: Int,
    val HinhAnhThuoc: String,
    val DonGia: Int,
    val ThongTin: String,
    val IdTheLoai: Int,
    val IdStatus: Int,
    val TenStatus: String,
    val TenTheLoai: String
){
    fun getId() : Int{
        return this.IdSanPham
    }

    fun getName() : String{
        return this.TenSanPham
    }

    fun getCount() : Int{
        return this.SoLuong
    }

    fun getImage() : String{
        return this.HinhAnhThuoc
    }

    fun getAmount() : Int{
        return this.DonGia
    }

    fun getDescription(): String{
        return this.ThongTin
    }

    fun getIDCategory() : Int{
        return this.IdTheLoai
    }

    fun getIDStatus() : Int{
        return this.IdStatus
    }

    fun getNameCategory(): String{
        return this.TenTheLoai
    }

    fun getNameStatus(): String{
        return this.TenStatus
    }

}