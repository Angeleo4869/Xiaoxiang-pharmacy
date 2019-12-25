import React,{useEffect} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';
import Card from '@material-ui/core/Card';
import Avatar from '@material-ui/core/Avatar';
import { deepOrange } from '@material-ui/core/colors';
import Button from '@material-ui/core/Button';
import Tooltip from '@material-ui/core/Tooltip';
import axios from 'axios';
import cookie from 'react-cookies';
import {
  Link
} from 'react-router-dom';

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
  address: {
    width:`100%`,
    [theme.breakpoints.down('sm')]: {
      width:`calc(100vw - 250px)`,
    },
  },
  orange: {
    color: '#fff',
    backgroundColor: deepOrange[500],
  },
}));

const longText ='添加新地址';

// const ConT =[{name:'折原临也',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
// { name:'平和岛静雄',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
// {name:'伊藤健太郎',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
// ];
export default function PaperSheet() {
  const classes = useStyles();
  const [Adata,setAdata] = React.useState(
    [
      {"addressDetail":"0",
      "city":"0",
      "idShippingAddress":1,
      "provinces":"0",
      "recipientName":"网络连接错误",
      "recipientTel":"0"},
      {"addressDetail":"0","city":"0","idShippingAddress":2,"provinces":"0","recipientName":"0","recipientTel":"0"}
    ])

  useEffect(
    ()=>{
      if(cookie.load('userId')!=null){
        axios.get(global.data.request+'ViewAddress.action',
        {
          params: {
            idBuyer:cookie.load('userId')
          }
        }).then(
          (response)=>{
            setAdata(response.data.shippingaddress);
            sessionStorage.setItem("addr" , JSON.stringify(response.data.shippingaddress));
          }
        )
    }else{
      alert("请登录")
      window.location.href = global.data.localadd +'Login'
    }

    },[]
  )
  const modify = (event,id,name,phone,province,city,detail)=>{
    var content = {'id':id,'name':name,'phone':phone,'province':province,'city':city,'detail':detail}
    sessionStorage.setItem("Defaultmessage",JSON.stringify(content))
    // window.location.href= global.data.localadd +'PersonCenter/show/Modifyaddress'
  }
  
  const cdelete = (event,id)=>{
    alert(id)
  }
      // alert(Adata[0].city)
      // console.log(Adata)
  return (
    <div style={{width:'100%'}}>
      
      <div style={{display:'flex',width:'100%'}}>
          <Typography variant="h6" style={{margin:5,marginLeft:15}} >
              我的地址
          </Typography>
          <Link to="/PersonCenter/show/Newaddress">
            <Tooltip title={longText} placement="left">
              <Fab color="primary" aria-label="add" style={{position:'absolute',right:10,marginTop:10,height:40,width:40}}>
                  <AddIcon />
              </Fab>
            </Tooltip>
          </Link>
      </div>

      <Divider style={{position:'relative',top:10,left:10}}/>
        {Adata.map((text,index)=>(
          <Card key={index} className={classes.cardstyle} style={{height:70,marginTop:20}}>
            <div style={{display:'flex'}}>
              <Avatar className={classes.orange} style={{position:'relative',top:15,left:15}}>{text.recipientName.charAt(0)}</Avatar>
              <div style={{display:'inline'}}>
                <Typography variant="h7" style={{margin:5,marginLeft:30}} >
                  {text.recipientName}
                </Typography>
                <Typography variant="h7" style={{margin:5,marginLeft:30}} >
                  {text.recipientTel}
                </Typography>
                <div className={classes.address} style={{margin:5,marginLeft:25}}>
                  <Typography variant="h7" style={{margin:5,position:'relative',top:7}} >
                    {text.provinces}{text.city}{text.addressDetail}
                  </Typography>
                </div>
              </div>
              <Divider orientation="vertical" />
              <div style={{display:'flex',position:'absolute',margin:5,marginLeft:15,right:30}}>
                <Link to="/PersonCenter/show/Modifyaddress" onClick={(e)=>modify(e,text.idShippingAddress,text.recipientName,text.recipientTel, text.provinces,text.city,text.addressDetail)}>
                  <Button  variant="outlined" size="small" color="primary" style={{marginLeft:5,position:'relative',top:15,right:-30}}>
                    编辑
                  </Button>
                </Link>
                <Button onClick={(e)=>cdelete(e,text.idShippingAddress)} variant="outlined" size="small" color="secondary" style={{marginLeft:5,position:'relative',top:15,right:-30}}>
                  删除
                </Button>
              </div>
            </div>
          </Card>
        ))} 
        <div style={{height:95}}>s</div>{/* 注意一定要加，不然显示不全 */}
    </div>
  );
}