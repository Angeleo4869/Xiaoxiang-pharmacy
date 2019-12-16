import React from 'react';
import Paper from '@material-ui/core/Paper';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import PhoneIcon from '@material-ui/icons/Phone';
import { Hidden } from '@material-ui/core';

const useStyles = makeStyles(theme => ({
    root: {
        backgroundColor: theme.palette.background.paper,
        width: '100%',
        marginLeft:10,
        marginTop:20,
    },
    paper: {
      padding: theme.spacing(3, 2),
      minHeight:'150%'
    },
    list: {
      display: 'flex',
    },
    img: {
      width:80,
      height:50,
    }
  }));

export default function orderList(props){
    const classes = useStyles();
    return(
      <Paper className={classes.paper}>
        <List className={classes.list}>
          <Typography noWrap><PhoneIcon fontSize='small'/>{props.content.name}</Typography>
          <Typography noWrap style={{position:'absolute',right:'2%'}}>{props.content.state}</Typography>
        </List>
        <List className={classes.list}>
          <img className={classes.img} alt="complex" src={props.content.imagesrc} />
          <span style={{position:'absolute',left:85,width:250,height:30}}>
          <p > {props.content.goodname}
          </p>
          </span>
          <h6 style={{position:'absolute',right:5}}>￥{props.content.finprice}</h6>
          <Hidden smDown>
            <List style={{position:'absolute',left:340,width:50,height:30}}>
              <Typography><s>￥{props.content.preprice}</s></Typography>
              <Typography>￥{props.content.price}</Typography>
            </List>
          </Hidden>
          <Hidden smDown>
            <List style={{position:'absolute',right:80,width:70,height:50}}>
              <Typography fontSize='small'>交易状态</Typography>
              <Typography>订单详情</Typography>
              <Typography>查看物流</Typography>
            </List>
          </Hidden>
        </List>
        <Hidden smUp>
            <List style={{display:'flex',position:'relative',top:20}}>
              <Typography fontSize='small'>交易状态</Typography>
              <Typography>订单详情</Typography>
              <Typography>查看物流</Typography>
            </List>
          </Hidden>
          <hr style={{position:'relative',top:28}}/>
      </Paper>
    );
  }