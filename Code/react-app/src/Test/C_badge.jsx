import React from 'react';
import { Button } from '@material-ui/core';
import Badge from '@material-ui/core/Badge';
import MailIcon from '@material-ui/icons/Mail';
export default class C_badge extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            B_num : props.B_num,
        }
    }
    shouldComponentUpdate(){//返回false则不渲染
        if(this.state.B_num<=0){
            return false;
        }
        return true;
    }
    componentWillUpdate(){
        if(this.state.B_num<0){
            this.state.B_num=0;
        }
        
    }
    render(){
        const fun1=()=>{
            var v_num = this.state.B_num-1
            this.setState({
                B_num : v_num
            })
          }
        return(
            <div style={{position:'absolute',right:10}}>
                <Badge color="secondary" 
                showZero={false} 
                max={99} 
                badgeContent={this.state.B_num}   
               >
                    <MailIcon />
                </Badge>
                {this.state.B_num}<Button onClick={fun1}>change</Button>
            </div>
        )
    }
}