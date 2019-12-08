import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Chip from '@material-ui/core/Chip';
import Avatar from '@material-ui/core/Avatar';
import PanelContent from './messageContent';

function TabPanel(props) {
  const { children, value, index, ...other } = props;
  const classes = useStyles();
  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`vertical-tabpanel-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
      className={classes.fullwid}
      {...other}
    >
      {value === index && <Box p={3} style={{width:'100%'}}>{children}</Box>}
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
    id: `vertical-tab-${index}`,
    'aria-controls': `vertical-tabpanel-${index}`,
  };
}

const tablist =['ITEM ONE','ITEM TWO','ITEM THREE'];
const tablist2 =[{name:'ITEM ONE',img:'moren',message:[{con:'0',mess:'diyddddige'},{con:'1',mess:'dieaaaaaaaarge'},{con:'0',mess:'diige'},{con:'1',mess:'diaaaage'}]},
    {name:'ITEM TWO',img:'moren',message:[{con:'1',mess:'diyige'},{con:'0',mess:'dierge'}]},
    {name:'ITEM THREE',img:'moren',message:[{con:'0',mess:'diyige'},{con:'1',mess:'dierge'}]},
    
  ];

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
    display: 'flex',
    height: `calc(100vh - 150px)`,
    marginLeft:5,
  },
  tabs: {
    borderRight: `1px solid ${theme.palette.divider}`,
    width:`calc(50vw - 250px)`,
    minWidth:135,
    maxWidth:250,
    [theme.breakpoints.down('xs')]: {
      width: '80',
    },
  },
  fullwid: {
    width:`calc(100vw - 430px)`,
    [theme.breakpoints.down('xs')]: {
      width: `calc(100vw - 80px)`,
    },
  }
}));


export default function VerticalTabs() {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);
  const [chipData, setChipData] = React.useState(tablist2);
  const handleDelete = chipToDelete => () => {
    console.log(chipData[0])
    setChipData(chips => chips.filter(chip => chip.name !== chipToDelete.name));
  };
  const handleChange = (event, newValue) => {
    console.log(newValue);
    setValue(newValue);
  };

  return (
    <div>
        <Typography variant="h6">我的消息</Typography>
        <div className={classes.root}>
          <Tabs
              orientation="vertical"
              variant="scrollable"
              value={value}
              onChange={handleChange}
              aria-label="Vertical tabs example"
              className={classes.tabs}
          >
              {chipData.map(
                  (text,index)=>( 
                      <Tab key={index} 
                          style={{position:'relative',left:0}}
                          label={<Chip
                                  
                                  label={text.name} 
                                  onDelete={handleDelete(text)}
                                  avatar={<Avatar src="/Pic/D1.jpg" />} 
                              />} 
                      {...a11yProps({index})}> 
                      </Tab>
                  )
              )}
              <Tab label="" {...a11yProps(100)}></Tab>
          </Tabs>
          {chipData.map(
            (text,index)=>(
              <TabPanel key={index} value={value}  index={index}>
                <PanelContent text={text.message}/>
              </TabPanel>
            )
          )}
          
        </div>
        <div style={{height:95}}>s</div>{/* 注意一定要加，不然显示不全 */}
    </div>
  );
}