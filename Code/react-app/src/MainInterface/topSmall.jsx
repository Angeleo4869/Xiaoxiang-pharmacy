import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Divider from '@material-ui/core/Divider';
import { Link } from '@material-ui/core';
import Typography from '@material-ui/core/Typography';
import Center from 'react-center';
// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    // float:'right', 
  },
  divs: {
    position: 'relative',
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
        <div className={classes.divs}><Center>
          <div className={classes.div}>
            <Typography noWrap >您好，<Link className={classes.link} href="//www.baidu.com" >请登录</Link></Typography>
            <Divider className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >注册</Typography></Link>
            <Divider className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >个人中心</Typography></Link>
            <Divider className={classes.links} className={classes.divider} orientation="vertical" />
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >在线客服</Typography></Link>
            <Divider className={classes.links} className={classes.divider} orientation="vertical" />
            <Link className={classes.links} to="/Test" ><Typography noWrap >测试</Typography></Link>
          </div>
          </Center>
        </div>
         
    );
  }
export default Top;