import React from 'react';
import { List } from '@material-ui/core';
import Button from '@material-ui/core/Button'
import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';
import Box from '@material-ui/core/Box';
import cookie from 'react-cookies';
import {
    Link
  } from 'react-router-dom';
  
export default class norms extends React.Component{
    constructor(props){
        super(props);
        this.state={
             Gnum:1
        }
    }
    fLogin = () =>{
        if(cookie.load('userId')===this.props.user){
            //创建订单页数据
            var GoodData = {"value" : [{
                "Gname":this.props.Gdata.goodsComName,
                "Gspec":this.props.Gdata.goodsSpecifications,
                "Gprice":this.props.Gdata.storePurchasePrice,
                "Gnum":this.state.Gnum,
                "Gimage":"",
                "idGoods":this.props.Gdata.idShopGoods,
                "buyerid":cookie.load('userId'),
                "goodid":this.props.Gdata.idGoods
                }],
                "GFprice":this.props.Gdata.storePurchasePrice*this.state.Gnum,
                "Ordernum" :1,
                "orderaddress" :""
            };
            sessionStorage.setItem("DDorder",JSON.stringify(GoodData))
            window.location.href = global.data.localadd+"ImedPurchase"
        }else{
            alert("请先登录")
        }
    }

    addGunm=()=>{
        this.setState({
            Gnum : this.state.Gnum+1
        })
    }
    subGnum=()=>{
        if(this.state.Gnum>0){
           this.setState({
                Gnum : this.state.Gnum-1
            })
        }
    }
    render(){
        
        return(
            <List style={{position:'relative',left:10,top:0}}>
                <div style={{display:'flex'}}>
                <h2>商品名称:&nbsp;</h2><h5 style={{marginTop:27}}>{this.props.Gdata.goodsComName}</h5>
                </div>
                <div style={{display:'flex'}}>
                <h3>规格选择区:&nbsp;</h3><h5 style={{marginTop:20}}>{this.props.Gdata.goodsSpecifications}</h5>
                </div>
                <div style={{display:'flex'}}>
                <h3>数量选择:&nbsp;</h3>
                    <div style={{display:'flex',marginTop:20}}>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <AddIcon onClick={this.addGunm}/>
                        </Box>
                        <Box style={{height:25,width:40,border:'1px solid #f0f0f0'}}>
                            <center>
                            <h3 style={{marginTop:2,}}>{this.state.Gnum}</h3>
                            </center>
                        </Box>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <RemoveIcon onClick={this.subGnum}/>
                        </Box>
                    </div>
                </div>
                <div>
                    <h3>价格：{parseFloat(this.props.Gdata.storePurchasePrice*this.state.Gnum).toFixed(1)}</h3>
                </div>
                <div><Button>加入购物车</Button>
                
                <Button onClick={this.fLogin}>立即购买</Button>
                
                </div>
            </List>
        );
    };
}