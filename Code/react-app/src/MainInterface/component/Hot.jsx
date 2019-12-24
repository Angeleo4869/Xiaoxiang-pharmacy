import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Link } from '@material-ui/core';
import Typography from '@material-ui/core/Typography';
import Hidden from '@material-ui/core/Hidden';
// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    width:300,
    marginRight:'45%',
    float:'right', 
    [theme.breakpoints.down('sm')]: {
      marginRight:'10%',
    },
    [theme.breakpoints.down('md')]: {
      marginRight:'30%',
    },
  },
  divs: {
    position:'relative',
    width:'100%',
    // background: '#EEEEEE',
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
          <div className={classes.div}><Hidden smDown>
            <Link className={classes.link} href="//www.baidu.com" ><Typography noWrap >阿胶</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >感冒</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >逍遥丸</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >补肺丸</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >血压计</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >护理液</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >博路定</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >护理液</Typography></Link>&nbsp;&nbsp;
            <Link className={classes.links} href="//www.baidu.com" ><Typography noWrap >博路定</Typography></Link>
            </Hidden>
          </div>
        </div>
         
    );
  }
export default Top;