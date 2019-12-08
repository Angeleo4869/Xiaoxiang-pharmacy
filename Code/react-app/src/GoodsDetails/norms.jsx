import React from 'react';
import { List } from '@material-ui/core';
import Button from '@material-ui/core/Button'
import {
    Link
  } from 'react-router-dom';
export default class norms extends React.Component{
    render(){
        return(
            <List style={{position:'relative',left:10,top:0}}>
                <h2>商品名称</h2>
                <h3>上商品详情</h3>
                <h3>规格选择区</h3>
                <h3>数量选择</h3>
                <div><Button>加入购物车</Button>
                <Link to="/ImedPurchase">
                     <Button>立即购买</Button>
                </Link>
                </div>
            </List>
        );
    };
}