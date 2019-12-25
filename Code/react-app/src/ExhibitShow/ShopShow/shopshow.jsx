import React from 'react';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import SwipeableViews from 'react-swipeable-views';
import { autoPlay } from 'react-swipeable-views-utils';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Box from '@material-ui/core/Box';
import PropTypes from 'prop-types';
import Panel11 from'./conponent/panel11';
import Panel12 from'./conponent/panel12';
import Goodscard from'./conponent/goodscard';
import Newgoods from'./conponent/newgoods';

const useStyles = makeStyles(theme => ({
  root: {
    maxWidth: 400,
    flexGrow: 1,
    
  },
  header: {
    display: 'flex',
    alignItems: 'center',
    height: 50,
    paddingLeft: theme.spacing(4),
    backgroundColor: theme.palette.background.default,
  },
  img: {
    height: 255,
    display: 'block',
    maxWidth: 400,
    overflow: 'hidden',
    width: '100%',
  },
  cardstyle: {
    position:'relative',
    left:-9,
    width:`calc(100vw - 0px)`,
    minWidth:200,
    [theme.breakpoints.down('xs')]: {
        width: '97vw',
    },
  },
  root1: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
  paper: {
    padding: theme.spacing(2),
    margin: 'auto',
    maxWidth: 500,
  },
  change :{
    display:'flex',
    [theme.breakpoints.down('xs')]: {
      display:'inline',
      width:400,
   },
  }
}));


function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <Typography
      component="div"
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && <Box p={3}>{children}</Box>}
    </Typography>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

function SwipeableTextMobileStepper() {
  document.title = "店铺主页";
  const classes = useStyles();
  const [value, setValue] = React.useState(0);
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div className={classes.root} style={{width:`calc(100vw)`}}>
      <Paper className={classes.cardstyle}>
        <center>
          <img src={ '/Pic/activity.jpg'} style={{width:`calc(100vw)`}}></img>
        </center>
      </Paper>
      <div className={classes.cardstyle} >
        <AppBar position="static" style={{width:`calc(100vw)`}}>
          <Tabs value={value} onChange={handleChange} aria-label="simple tabs example" >
            <Tab label="首页" {...a11yProps(0)}/>
            <Tab label="全部商品" {...a11yProps(1)}/>
            <Tab label="新品" {...a11yProps(2)}/>
          </Tabs>
        </AppBar>
        <TabPanel value={value} index={0} >
            <div className={classes.change} >
              <Panel11/>
              <Panel12/> 
            </div>
        </TabPanel>
        <TabPanel value={value} index={1}>
          <div className={classes.change} >
            <Goodscard/>
          </div>
        </TabPanel>
        <TabPanel value={value} index={2}>
        <div className={classes.change} >
            <Newgoods/>
          </div>
        </TabPanel>             
      </div>             
    </div>
  );
}

export default SwipeableTextMobileStepper;