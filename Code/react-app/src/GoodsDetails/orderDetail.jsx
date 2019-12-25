import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import LocalShippingIcon from '@material-ui/icons/LocalShipping';
import HomeIcon from '@material-ui/icons/Home';
import Card from '@material-ui/core/Card';
import Button from '@material-ui/core/Button';
import StorefrontIcon from '@material-ui/icons/Storefront';
const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(1, 3),
    marginLeft:10,
  },
  cardstyle: {
    position:'relative',
    left:10,
    width:`calc(100vw - 230px)`,
    minWidth:200,
    [theme.breakpoints.down('xs')]: {
        width: '96vw',
    },
  },
  image: {
    width:240,
    height:'auto',
    [theme.breakpoints.down('xs')]: {
      width:150,
      height:'auto',
    }
  },
  phonenumber: {
    position:'absolute',
    maginLeft:40,
    marginTop:10,
    left:`calc(20vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    left:`calc(35vw - 10px)`,
    }
  },
  address: {
    maginLeft:10,
    marginTop:35,
    position:'absolute',
    left:`calc(4.75vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    left:`calc(12vw - 5px)`,
    }
  },
  shop: {
    marginTop:12.5,
    position:'absolute',
    left:`calc(4vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    left:`calc(10vw - 10px)`,
    }
  },
  detail1: {
    maginLeft:0,
    marginTop:90,
    position:'absolute',
    left:`calc(20vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    marginTop:70,
    left:`calc(35vw - 10px)`,
    }
  },
  detail2: {
    maginLeft:0,
    marginTop:150,
    position:'absolute',
    left:`calc(20vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    marginTop:120,
    left:`calc(35vw - 10px)`,
    }
  },
  detail3: {
    maginLeft:0,
    marginTop:170,
    position:'absolute',
    left:`calc(20vw - 10px)`,
    color:'#FFB6C1',
    [theme.breakpoints.down('xs')]: {
    marginTop:135,
    left:`calc(35vw - 10px)`,
    }
  },
  detail4: {
    maginLeft:0,
    marginTop:190,
    position:'absolute',
    left:`calc(20vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    marginTop:150,
    left:`calc(35vw - 10px)`,
    }
  },
  detail5: {
    maginLeft:0,
    marginTop:250,
    position:'absolute',
    right:`calc(5vw - 10px)`,
    [theme.breakpoints.down('xs')]: {
    marginTop:170,
    right:`calc(5vw - 10px)`,
    }
  },
  detail6: {
    maginLeft:0,
    marginTop:270,
    position:'absolute',
    right:`calc(5vw - 10px)`,
    color:'#FFB6C1',
    [theme.breakpoints.down('xs')]: {
    marginTop:185,
    right:`calc(5vw - 10px)`,
    }
  },
}));
export default function PaperSheet() {
  const classes = useStyles();
  return (
    <div style={{width:'100%'}}>
      
        <Card style={{marginLeft:15}}>
        <div style={{display:'flex',width:'100%',position:'relative'}}>
            <LocalShippingIcon style={{marginLeft:10,marginTop:10,fontSize: 40}} color="primary"/>
            <Typography color="textSecondary" variant="h6" style={{maginLeft:40,marginTop:15}} >
                已发货，运输中
            </Typography>
        </div>
        <Divider style={{position:'relative',top:10,left:10}}/>
        <div style={{display:'flex',width:'100%',position:'relative'}}>
            <HomeIcon style={{marginLeft:10,marginTop:10,fontSize: 40}} color="primary"/>
            <Typography variant="h7" style={{maginLeft:40,marginTop:10}} >
                安谷奈绪
            </Typography>
            <Typography variant="h7" className={classes.phonenumber}>
                18823457653
            </Typography>
            <br/>
            <Typography variant="h7" className={classes.address} >
                湖南省 长沙市 岳麓区 学士街道 湖南中医药大学含浦校区
            </Typography>
        </div>
        <Divider style={{position:'relative',top:10,left:10}}/>
        <div style={{display:'flex'}}>
        <div style={{position:'relative',top:10,left:5}}>
            <StorefrontIcon style={{marginLeft:12.5,marginTop:10}}color="action" />
            <Typography variant="h7" className={classes.shop} >
                益丰大药房
            </Typography>
            <br/>   
            <img className={classes.image} src='/Pic/yao.jpg'/>
        </div>
        <div style={{display:'inline'}}>
            <Typography  className={classes.detail1} >
                品名：氯芬黄敏片
                <br/>
                规格：24片/板*25板
            </Typography>
            <Typography variant="h7" className={classes.detail2} >
                平邮：0.00元
            </Typography>
            <Typography color="secondary" variant="h7" className={classes.detail3} >
                单价：19.90元
            </Typography>
            <Typography variant="h7" className={classes.detail4} >
                数量：1
            </Typography>
            <Typography variant="h7" className={classes.detail5} >
                总价：19.90元
            </Typography>
            <Typography  variant="h7" className={classes.detail6} >
                实付款：19.90元
            </Typography>
        </div>
        </div>
          <Card className={classes.cardstyle} style={{height:70,marginTop:20,marginLeft:-10}}>
              <div style={{display:'flex',position:'absolute',margin:5,marginLeft:5,right:30}}>
                <Button variant="outlined" size="small" color="secondary" style={{marginLeft:5,position:'relative',top:15,right:-10}}>
                  退款
                </Button>
              </div>
          </Card>
        </Card>
        
        <Divider style={{height:95}}/>
        
    </div>
  );
}