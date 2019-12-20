import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import CardMedia from '@material-ui/core/CardMedia';
import { Hidden } from '@material-ui/core';
import MenuRoundedIcon from '@material-ui/icons/MenuRounded';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import useMediaQuery from '@material-ui/core/useMediaQuery';
import { useTheme } from '@material-ui/core/styles';
import GlobalData from './../GlobalData';
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
    backgroundColor: "#F0F0F0",
    [theme.breakpoints.down('sm')]: {
        marginTop:0,
        bottom:0,
    },
  },
  cardmedia: {
      width: '330px',
      height:'300px',
  }
}));

function ResponsiveDialog() {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false);
    const theme = useTheme();
    const fullScreen = useMediaQuery(theme.breakpoints.down('xs'));
  
    const handleClickOpen = () => {
      setOpen(true);
    };
  
    const handleClose = () => {
      setOpen(false);
    };
    const PayedThenhandleClose = () => {
        setOpen(false);
      };
    return (
      <div>
        <Button variant="contained" color="primary" onClick={handleClickOpen}>
          提交订单
        </Button>
        <Dialog
          fullScreen={fullScreen}
          open={open}
          onClose={handleClose}
          aria-labelledby="responsive-dialog-title"
        >
          <DialogTitle id="responsive-dialog-title">{"欢迎使用潇湘支付"}</DialogTitle>
          <DialogContent>
            <DialogContentText>
              请扫描下方二维码，支付完成后点击支付完成。您的宝贝即将发货！
              <center>
              <CardMedia
                    className={classes.cardmedia}
                    image="/Pic/pay.png"
                    title="Scan It Now!!!"
                />
                </center>
            </DialogContentText>
          </DialogContent>
          <DialogActions>
            <Button autoFocus onClick={handleClose} color="primary">
              取消
            </Button>
            <Button onClick={PayedThenhandleClose} color="primary" autoFocus>
              支付完成
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }

export default function imedPurchase() {
  const classes = useStyles();

  const conT =[
    {name:'xiaofeng',num:1,price:29.9},
    {name:'dafeng',num:1,price:28.9}
    ]
    var Sprice = 0;
    for(var j = 0,len = conT.length; j < len; j++){
        Sprice+=conT[j].price;
    }


//地址栏采用全局数据，在进入此界面时获取
  return (
      <div>
        <Typography>立即购买</Typography>
        <Paper>
            <div style={{display:'flex'}}>
                <MenuRoundedIcon/>
                <div style={{display:'inline'}}>
                    <div style={{display:'flex'}}>
                        <Typography  component="h5" >
                            {GlobalData.address[0]} &nbsp;&nbsp;&nbsp;&nbsp;
                        </Typography>
                        <Typography  component="h6" >
                            {GlobalData.address[1]}
                        </Typography>
                    </div>
                    <Typography  component="h5" >
                            {GlobalData.address[2]}
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
                <Typography  component="h6" style={{marginTop:5}}>
                    共{conT.length}件&nbsp;合计
                </Typography>
                <Typography  component="h6" style={{marginTop:5,color:"#FF0000"}}>
                    ￥{Sprice}&nbsp;&nbsp;
                </Typography>
                {/* <Button>提交订单</Button> */}
                <ResponsiveDialog/>
            </div>
        </Paper>
        </div>
    );
}