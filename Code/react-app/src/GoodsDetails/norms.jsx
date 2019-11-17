import React from 'react';
import { List } from '@material-ui/core';
import Button from '@material-ui/core/Button'
export default class norms extends React.Component{
    render(){
        return(
            <List style={{position:'relative',left:150,top:-40}}>
                <h2>商品名称</h2>
                <h3>上商品详情</h3>
                <h3>规格选择区</h3>
                <h3>数量选择</h3>
                <div><Button>加入购物车</Button><Button>立即购买</Button></div>
            </List>
        );
    };
}