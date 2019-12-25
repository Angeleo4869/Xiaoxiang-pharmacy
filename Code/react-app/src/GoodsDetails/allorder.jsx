import React ,{useEffect} from 'react';
import PropTypes from 'prop-types';
import SwipeableViews from 'react-swipeable-views';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
// import Box from '@material-ui/core/Box';
import PhoneIcon from '@material-ui/icons/Phone';
import FavoriteIcon from '@material-ui/icons/Favorite';
import PersonPinIcon from '@material-ui/icons/PersonPin';
import Box from '@material-ui/core/Box';

// import OrderDetails from './orderDetails';
import OrderDetails from './maporderDetail';
import axios from 'axios';
import cookie from 'react-cookies'
import {
  useLocation
} from "react-router-dom";
import { Hidden } from '@material-ui/core';
function TabPanel(props) {
  // const { children, content, value, index, ...other } = props;
  const hii = props.value!==props.index;
  
  return (
    <div stye={{hidden:hii, width: `calc(100vw - 23px)`}} >
    {/* <Typography
      component="div"
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
      {...other}
    >  </Typography> */}


    {props.content && props.content.map((text,index) => (
       <Box border={0} key={index} >
           <OrderDetails  content={text}/>
        </Box>
    ))}
    <div style={{height:95}}><hr/></div>
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    'aria-controls': `full-width-tabpanel-${index}`,
    
  };
}

const useStyles = makeStyles(theme => ({
  root: {
    backgroundColor: theme.palette.background.paper,
    position: "relative",
    marginLeft:10,
    width:'100%',
    [theme.breakpoints.down('sm')]: {
      width: `calc(100vw - 23px)`,
    }
  },
  appbar: {
    width: `calc(100vw - 220px)`,
    [theme.breakpoints.down('xs')]: {
      width: `calc(100vw)`,
    }
  }
  
}));

// var content1 = [[ {name:'潇湘药房1',imagesrc:'/Pic/D1.jpg',goodname:'USB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待付款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待付款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待付款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待付款'}
//                 ],
//                 [
//                   {name:'潇湘药房2',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待发货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待发货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待发货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待发货'}
//                 ],
//                 [
//                   {name:'潇湘药房3',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待收货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待收货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待收货'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待收货'}
//                 ],
//                 [
//                   {name:'潇湘药房4',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待评价'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待评价'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待评价'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'待评价'}
//                 ],
//                 [
//                   {name:'潇湘药房5',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'申请退款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'申请退款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'申请退款'},
//                   {name:'潇湘药房',imagesrc:'/Pic/D1.jpg',goodname:'USBB分线器拓展器 USB分线器拓展器',preprice:'29,9',price:'9.9',finprice:'9.9',state:'申请退款'}
//                 ]
//               ];
function useQuery() {
  return new URLSearchParams(useLocation().search);
}
export default function FullWidthTabs() {
  const classes = useStyles();
  const theme = useTheme();
  let query = useQuery().get('tab');
  // alert(query)
  const [Odata, setOdata] = React.useState(
    [
      [{"id":{"idStore":0,"idbuyer":11,"idorder":1,"odNumber":1,"odprice":40.0,"odstate":0,"shPrice":40.0,"shimage":"0001","shname":"板蓝根·","storename":"仁和药房"}}],
      [{"id":{"idStore":0,"idbuyer":11,"idorder":2,"odNumber":1,"odprice":20.9,"odstate":1,"shPrice":20.9,"shimage":"0001","shname":"感冒灵 ","storename":"九芝堂大药房"}}],
      [{"id":{"idStore":0,"idbuyer":11,"idorder":3,"odNumber":1,"odprice":20.9,"odstate":2,"shPrice":20.9,"shimage":"0001","shname":"感冒灵 ","storename":"九芝堂大药房"}}],
      [{"id":{"idStore":0,"idbuyer":11,"idorder":4,"odNumber":1,"odprice":20.9,"odstate":3,"shPrice":20.9,"shimage":"0001","shname":"感冒灵","storename":"仁和药房"}}]
      ,[{"id":{"idStore":0,"idbuyer":11,"idorder":5,"odNumber":1,"odprice":20.9,"odstate":4,"shPrice":20.9,"shimage":"0001","shname":"感冒灵","storename":"仁和药房"}}]
    ]
    );
      const [value, setValue] = React.useState(Number(query));
  //在function组件中使用变量变化触发的函数
  useEffect(() => {
    if(cookie.load('userId')==null){
      alert("请先登录")
      window.location.href = global.data.localadd+"Login"
    }
    axios.get(global.data.request+'ViewOrder.action',
      {
        params: {
          idBuyer:cookie.load('userId')
        }
      }).then(
        (response)=>{
          setOdata(response.data.Oder);
          
          // console.log(response.data.Oder[3])
        }
    )
    setValue(query);
  }, [query]);
  // console.log(Odata[0][0])  
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = index => {
    setValue(index);
  };

  return (
    <div className={classes.root}>
      <Hidden smUp>
      <AppBar position="relative" color="#000000" style={{width:'100%'}} >
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          textColor="primary"
          variant="standard"
          aria-label="full width tabs example"
          className={classes.appbar}
          centered
        >
        <Tab style={{minWidth:20}} icon={<PhoneIcon />} label="待付款" {...a11yProps(0)}/>
        <Tab style={{minWidth:20}} icon={<FavoriteIcon />} label="待发货" {...a11yProps(1)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="待收货" {...a11yProps(2)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="待评价" {...a11yProps(2)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="退款" {...a11yProps(2)} />
         
        </Tabs>
      </AppBar>
      </Hidden>
      <Hidden xsDown>
      <AppBar position="relative" color="#000000" style={{width:'100%'}} >
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          textColor="primary"
          variant="standard"
          aria-label="full width tabs example"
          className={classes.appbar}
        >
        <Tab style={{minWidth:20}} icon={<PhoneIcon />} label="待付款" {...a11yProps(0)}/>
        <Tab style={{minWidth:20}} icon={<FavoriteIcon />} label="待发货" {...a11yProps(1)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="待收货" {...a11yProps(2)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="待评价" {...a11yProps(2)} />
        <Tab style={{minWidth:20}} icon={<PersonPinIcon />} label="退款" {...a11yProps(2)} />
         
        </Tabs>
      </AppBar>
      </Hidden>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} content={Odata[0]} dir={theme.direction}>
        </TabPanel>
        <TabPanel value={value} index={1} content={Odata[1]} dir={theme.direction}>
        </TabPanel>
        <TabPanel value={value} index={2} content={Odata[2]} dir={theme.direction}>
        </TabPanel>
        <TabPanel value={value} index={3} content={Odata[3]} dir={theme.direction}>
        </TabPanel>
        <TabPanel value={value} index={4} content={Odata[4]} dir={theme.direction}>
        </TabPanel>
      </SwipeableViews>
    </div>
  );
}

