import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import CardMedia from '@material-ui/core/CardMedia';
import { Hidden } from '@material-ui/core';
import MenuRoundedIcon from '@material-ui/icons/MenuRounded';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(3, 2),
    marginTop:20,
    width: '90%',
    marginLeft: '1%'
  },
  cardimg: {
    minWidth: 50,
    height: 40,
    
  },
  typography_font: {
    fontSize: 2
  },
  tpyoStyle: {//商品属性
    width:80,
    marginLeft:'10%',
    marginRight:'9%',
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.down('xs')]: {
        marginRight: 3,
    },
  },
  tpytStyle: {//商品属性值
    width:110,
    marginRight:'5%',
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.down('xs')]: {
        marginRight: 3,
    },
  },
  tpyStyle: {
    width:80,
    marginRight:'2%',
    marginLeft:'2%',
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.down('xs')]: {
        marginRight: 3,
    },
  },
  conStyle: {
    width:110,
    marginRight:'3%',
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.up('xs')]: {
        marginRight: 3,
    },
  },
  priStyle: {
    width:50,
    marginRight:'5%',
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.down('xs')]: {
        marginRight: 3,
    },
  },
  numStyle: {
    width:10,
    [theme.breakpoints.down('sm')]: {
        marginRight:'5%',
    },
    [theme.breakpoints.up('xs')]: {
        marginRight: '5%',
    },
  },
  payButtonbar: {
    display:'flex',
    marginTop:50,
    right:0,
    position:'absolute',
    [theme.breakpoints.down('sm')]: {
        marginTop:0,
        bottom:0,
    },
  }
}));
const conT =[{name:'xiaofeng',num:1,price:29.9},{name:'dafeng',num:1,price:29.9}]
export default function imedPurchase() {
  const classes = useStyles();

  return (
      <div>
        <Typography>立即购买</Typography>
        <Paper>
            <div style={{display:'flex'}}>
                <MenuRoundedIcon/>
                <div style={{display:'inline'}}>
                    <div style={{display:'flex'}}>
                        <Typography  component="h5" >
                            小峰
                        </Typography>
                        <Typography  component="h6" >
                            15107361892
                        </Typography>
                    </div>
                    <Typography  component="h5" >
                            湖南中医药大学岳麓区学士街道湖南中医药大学含浦校区
                    </Typography>
                </div>
                <MenuRoundedIcon style={{position:'absolute',right:0,marginRight:10,paddingTop:12}}/>
            </div>
        </Paper>
        <Hidden xsDown>
            <div style={{display:"flex",marginTop:30}}>
                <Typography className={classes.tpyStyle} component="h3" >
                    商品名称
                </Typography>
                <Typography  className={classes.tpyoStyle} component="h3" >
                    商品属性
                </Typography>
                <Typography  className={classes.tpyStyle} component="h3" >
                    商品单价
                </Typography>
                <Typography  className={classes.tpyStyle} component="h3" >
                    数量
                </Typography>
                {/* <Typography  className={classes.tpyStyle} component="h3" >
                    优惠方式
                </Typography> */}
                <Typography className={classes.tpyStyle} component="h3" >
                    小计
                </Typography>
            </div>
        </Hidden>
        {conT.map(
            (text)=>(
                <Paper key={text.name} className={classes.root}>
                    <div style={{display:"flex"}}>
                        <CardMedia
                            className={classes.cardimg}
                            image="/Pic/D1.jpg"
                            title="Live from space album cover"
                        />
                        <div style={{width:140,marginRight:'9%'}}>
                            <Typography noWrap={true} component="h3" >
                                {text.name}
                            </Typography>
                            <Typography noWrap={true} className={classes.fontSize}>
                                7天无理由退货
                            </Typography>
                        </div>
                        <div className={classes.tpytStyle} >
                            <Typography noWrap={true} component="h3" >
                                颜色分类:红色
                            </Typography>
                            <Typography noWrap={true} className={classes.fontSize}>
                                尺寸:s
                            </Typography>
                        </div>
                        <div className={classes.priStyle}>
                            <Typography noWrap={true} component="h3" >
                                9.99
                            </Typography> 
                        </div>
                        
                        {/* <div className={classes.conStyle}>
                            <Typography noWrap={true} component="h3" >
                                暂无优惠
                            </Typography> 
                        </div> */}
                        <div className={classes.numStyle}>
                            <Typography noWrap={true} component="h3" >
                                1
                            </Typography> 
                        </div>
                        <div style={{position:'relative',right:10}}>
                            <Typography noWrap={true} component="h3" >
                                9.99
                            </Typography> 
                        </div>
                    </div>
                    {/* <Typography variant="h5" component="h3">
                        {text.name}
                    </Typography>
                    <Typography component="p">
                        {text.price}
                    </Typography> */}
                </Paper>
                )
            )}
        <Paper>
            <div className={classes.payButtonbar}>
                <Typography  component="h6" >
                    共1件
                </Typography>
                <Typography  component="h6" >
                    合计￥9.99
                </Typography>
                <Button>提交订单</Button>
            </div>
        </Paper>
        </div>
    );
}