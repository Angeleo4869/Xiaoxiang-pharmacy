import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
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
  },
  divider: {
    height: 15,
    margin: 5,
  },
  link:{
    color:'#000000'
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
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >家庭常备药</Typography></Link>&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >乙肝</Typography></Link>&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >传统滋补</Typography></Link>&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >男性早泄</Typography></Link>&nbsp;&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >控制三高</Typography></Link>
          </div>
          </Center>
        </div>
         
    );
  }
export default Top;