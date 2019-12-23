import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Link } from '@material-ui/core';
import Typography from '@material-ui/core/Typography';
// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    width:166,
    height:22,
    marginLeft:'14%', 
    background: '#19323a',
    [theme.breakpoints.down('md')]: {
        marginLeft:'10%',
    },
    [theme.breakpoints.down('sm')]: {
        marginLeft:'0%',
    },
  },
  divs: {
    background: '#5e5e5e',
    display:'flex',
    width:'100%',
    height:22,
  },
  divider: {
    height: 15,
    margin: 5,
  },
  link:{
    color:'#ffffff'
  },
  links:{
    color:'#ffffff'
  },
  divss:{
    display:'flex',
  },
}));
const Top = props =>{
  const classes = useStyles();
    return(
        <div className={classes.divs}>
          <div className={classes.div}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a className={classes.links}><Typography noWrap >所有商品分类</Typography></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            <div className={classes.divss}> &nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >家庭常备药</Typography></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >乙肝</Typography></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >传统滋补</Typography></Link>&nbsp;&nbsp;&nbsp;
            <div className={classes.links}>丨</div>&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >男性早泄</Typography></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >控制三高</Typography></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >中药抓药</Typography></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            
          
        </div>
         
    );
  }
export default Top;