import React from 'react';
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

import OrderDetails from './orderDetails';

function TabPanel(props) {
  // const { children, content, value, index, ...other } = props;
  return (
    <div >
    {/* <Typography
      component="div"
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
      {...other}
    >  </Typography> */}
    {props.content && props.content.map((text) => (
       <Box border={0}  >
           <OrderDetails  name={text.name} state={text.state}/>
        </Box>
    ))}
    <div style={{height:95}}>s</div>
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
      width:'68%',
    }

  },
  
}));

var content1 = [{name:'潇湘药房',state:'交易成功'},{name:'潇湘药房',state:'交易成功'},{name:'潇湘药房',state:'交易成功'},{name:'潇湘药房',state:'交易成功'}]

export default function FullWidthTabs() {
  const classes = useStyles();
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = index => {
    setValue(index);
  };

  return (
    <div className={classes.root}>
      <AppBar position="relative" color="" style={{width:'100%'}} >
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          textColor="primary"
          variant="standard"
          aria-label="full width tabs example"
          style={{width:'100%'}}
        >
        <Tab icon={<PhoneIcon />} label="待付款" {...a11yProps(0)}/>
        <Tab icon={<FavoriteIcon />} label="待发货" {...a11yProps(1)} />
        <Tab icon={<PersonPinIcon />} label="待收货" {...a11yProps(2)} />
        <Tab icon={<PersonPinIcon />} label="待评价" {...a11yProps(2)} />
        <Tab icon={<PersonPinIcon />} label="退款" {...a11yProps(2)} />
         
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} content={content1} dir={theme.direction}>
          {value}
        </TabPanel>
        <TabPanel value={value} index={1} content={content1} dir={theme.direction}>
          
        </TabPanel>
        <TabPanel value={value} index={2} content={content1} dir={theme.direction}>
          Item Three
        </TabPanel>
        <TabPanel value={value} index={3} content={content1} dir={theme.direction}>
          Item Three
        </TabPanel>
        <TabPanel value={value} index={4} content={content1} dir={theme.direction}>
          Item Three
        </TabPanel>
      </SwipeableViews>
    </div>
  );
}