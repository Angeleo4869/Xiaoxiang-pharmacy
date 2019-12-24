import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Divider from '@material-ui/core/Divider';
import { Link } from '@material-ui/core';
import Typography from '@material-ui/core/Typography';
// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    width:300,
    marginRight:'25%',
    float:'right', 
  },
  divs: {
    position:'relative',
    width:'100%',
    background: '#EEEEEE',
  },
  divider: {
    height: 15,
    margin: 5,
  },
  link:{
    color:'#ff0000'
  },
  links:{
    color:'#3c3c3c'
  },
}));
const Top = props =>{
  const classes = useStyles();
    return(
        <div className={classes.divs}>&nbsp;
          <div className={classes.div}>
            <Typography noWrap >您好，<Link className={classes.link} href="//www.baidu.com" >请登录</Link></Typography>
            <Divider className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >注册</Typography></Link>
            <Divider className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >个人中心</Typography></Link>
            <Divider className={classes.links} className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >在线客服</Typography></Link>
          </div>
        </div>
         
    );
  }
export default Top;