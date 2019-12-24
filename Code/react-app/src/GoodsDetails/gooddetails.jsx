import React,{useEffect} from 'react';
import axios from 'axios';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import { List,ListItem } from '@material-ui/core';
import SvgIcon from '@material-ui/core/SvgIcon';
import { blue, red } from '@material-ui/core/colors';
import { makeStyles } from '@material-ui/core/styles';
import Fab from '@material-ui/core/Fab';
import PersonIcon from '@material-ui/icons/Person';
import Divider from '@material-ui/core/Divider';
import Box from '@material-ui/core/Box';
import Avatar from '@material-ui/core/Avatar';
import Chip from '@material-ui/core/Chip';
//商品详情接口入口
import Rotate from './rotate';
import Norms from './norms';
import Tabs from './Tabs';

import  './../GlobalData';
import cookie from 'react-cookies';
import {Link} from 'react-router-dom';
import {
  useLocation
} from "react-router-dom";

  function HomeIcon(props) {
    return (
      <SvgIcon {...props}>
        <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />
      </SvgIcon>
    );
  }
//由cookie确认是否登录，由session确定此标签页登陆的，提示不要模拟登录
  function HomeChip() {
    const classes = useStyles();
    // console.log(sessionStorage.getItem("Umessage"))
    var message = sessionStorage.getItem("Umessage")?sessionStorage.getItem("Umessage"):"请不要模拟登录"
    var uuurl = message=="请不要模拟登录"?"":""
    if(cookie.load('userId'))
      return(
        <Link to="/PersonCenter">
        <Fab variant="extended" aria-label="like" className={classes.fab}>
        <Chip variant="outlined" 
              color="primary" 
              label={message}
              avatar={<Avatar src="/Pic/D1.jpg" />} 
        />
        </Fab></Link>)
        else{
          return(
            <Link to="/Login">
              <Fab variant="extended" aria-label="like" className={classes.fab}>
              <PersonIcon className={classes.extendedIcon}/>
              {/* <NavigationIcon className={classes.extendedIcon} /> */}
              lOGIN
              </Fab>
            </Link>
          )
        }
    
      
  }
//
  const useStyles = makeStyles(theme => ({
    fab: {
      margin: theme.spacing(1),
      position:"absolute",
      right:'5%',
    },
    extendedIcon: {
      marginRight: theme.spacing(1),
    },
    homeIcon: {
        marginTop:theme.spacing(1),
        
    },
    flexornot: {
      marginRight:130,
      display: 'initial',
      [theme.breakpoints.up('sm')]: {
        display:'flex',
      },
    },
   
  }));

  const boxProps = {
    m: 1,
    border: 0,
    marginTop:5,
  };

  function useQuery() {
    return new URLSearchParams(useLocation().search);
  }
//通过路由得到goodid再得到数据
export default function SimpleContainer() {
    const classes = useStyles();
    let query = useQuery();
    const [Gdata,steGdata] = React.useState({
      goodsCharacter: "0",
      goodsCheName: "0",
      goodsComName: "0",
      goodsComposition: "0",
      goodsManufacturer: "0",
      goodsNumber: "0",
      goodsProductionDate: "0",
      goodsSpecifications: "0",
      goodsTaboo: "0",
      goodsUsage: "0",
      goodsValidity: 0,
      idGoods: 0,
    })
    useEffect(
      ()=>{
        axios.get(global.data.request+'ViewGoodsDetail.action',
        {
          params: {
            idGoods:query.get("goodid")
          }
        }).then(
          (response)=>{
            console.log(response)
            steGdata( response.data.Goods);
          }
      )
      },[]
    )
    // console.log(Gdata)
    // alert(global.data.address[0])
    // global.data.address[0]="xiaofeng"
    // console.log(global.data)
    // alert(global.data.address[0])
  return (
    <React.Fragment>
      <CssBaseline />
      <Container maxWidth="lg">
        <List style={{display:'flex'}}>
        <Link to="">
          <HomeIcon
          className={classes.homeIcon}
          
          color="primary"
          fontSize="large"
          component={svgProps => {
            return (
              <svg {...svgProps}>
                <defs>
                  <linearGradient id="gradient1">
                    <stop offset="30%" stopColor={blue[400]} />
                    <stop offset="70%" stopColor={red[400]} />
                  </linearGradient>
                </defs>
                {React.cloneElement(svgProps.children[0], {
                  fill: 'url(#gradient1)',
                })}
              </svg>
            );
          }}
          />
        </Link>
        <HomeChip/>
        </List>
        <Divider style={{marginTop:30,light:true,}}/>
        <div className={classes.flexornot}>
          <Box borderColor="primary.main"  {...boxProps}>
            <ListItem key='1' style={{marginBottom:50,marginRight:10}} >
              <Rotate />
            </ListItem>
          </Box>
          <ListItem key='2'><Norms user={query.get("name")} Gdata={Gdata} /></ListItem>  
        </div>
        <Box><Tabs Gdata={Gdata}/></Box>
      </Container>
          
    </React.Fragment>
  );
}