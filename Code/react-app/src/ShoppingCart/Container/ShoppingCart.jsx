import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
// import SearchAppbar from '../Components/Appbar';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import PropTypes from 'prop-types';
import Typography from '@material-ui/core/Typography';
import GoodsTable from '../Components/GoodsTable';
import Box from '@material-ui/core/Box';
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
      <Box p={2}>{children}</Box>
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


const useStyles = makeStyles(theme => ({
  root: {
    width:'100%',
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

export default function FullWidthGrid() {
  const classes = useStyles();

  const [tabvalue, settabValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    settabValue(newValue);
  };
  return (
    <div className={classes.root}>
      <Grid container spacing={3}>       
        <Grid item xs sm>
          {/* <Paper className={classes.paper}>xs=12 sm=6</Paper> */}
          {/* 整体页面布局 */}

      <div className={classes.root}>
        <Grid item xs={3} sm={3}>
            <AppBar position="static" color="primary"></AppBar>   
        </Grid>
        <Tabs value={tabvalue} onChange={handleChange} aria-label="simple tabs example">
          <Tab label="购物车" {...a11yProps(0)} />
          <Tab label="收藏夹" {...a11yProps(1)} />
        </Tabs>
        <TabPanel value={tabvalue} index={0}>
          {/* 购物车表格 */}
              <GoodsTable/>
        </TabPanel>
        <TabPanel value={tabvalue} index={1}>
          {/* 收藏夹 */}

        </TabPanel>  
      </div>            

        </Grid>
      </Grid>
      <div style={{height:95}}>s</div>
    </div>
  );
}