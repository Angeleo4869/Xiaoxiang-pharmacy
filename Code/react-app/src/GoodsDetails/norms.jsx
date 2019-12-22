import React from 'react';
import { List } from '@material-ui/core';
import Button from '@material-ui/core/Button'
import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';
import Box from '@material-ui/core/Box';
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
                <h2>商品名称:&nbsp;</h2><h5 style={{marginTop:27}}>通宵胫骨贴</h5>
                </div>
                <div style={{display:'flex'}}>
                <h3>规格选择区:&nbsp;</h3><h5 style={{marginTop:20}}>10（包）*25g</h5>
                </div>
                <div style={{display:'flex'}}>
                <h3>数量选择:&nbsp;</h3>
                    <div style={{display:'flex',marginTop:20}}>
                        <AddIcon onClick={this.addGunm}/>
                        <Box style={{backgroundColor:"#F0F0F0",height:25,width:30,MozOutlineRadius:5}}>
                            <center>
                            <h3 style={{marginTop:2,}}>{this.state.Gnum}</h3>
                            </center>
                        </Box>
                        <RemoveIcon onClick={this.subGnum}/>
                    </div>
                </div>
                <div><Button>加入购物车</Button>
                <Link to="/ImedPurchase">
                     <Button>立即购买</Button>
                </Link>
                </div>
            </List>
        );
    };
}