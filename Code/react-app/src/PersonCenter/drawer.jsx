import React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Divider from '@material-ui/core/Divider';
import Drawer from '@material-ui/core/Drawer';
import Hidden from '@material-ui/core/Hidden';
import IconButton from '@material-ui/core/IconButton';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import MailIcon from '@material-ui/icons/Mail';
import MenuIcon from '@material-ui/icons/Menu';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import ChevronRightOutlinedIcon from '@material-ui/icons/ChevronRightOutlined';
//个人中心模块接口
import {
    Route,
    Link,
    Switch,
    useRouteMatch,
    useLocation
  } from 'react-router-dom';
import App from './PTcontent';
import App2 from './../Test/App2';
import App3 from './../Test/App3';
import './../CSS/Center.css';


const drawerWidth = 200;

const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  drawer: {
    [theme.breakpoints.up('sm')]: {
      width: drawerWidth,
      flexShrink: 0,
    },
  },
  appBar: {

    [theme.breakpoints.up('sm')]: {
      width: `calc(100% - ${drawerWidth}px)`,
      marginLeft: drawerWidth,
    },
  },
  menuButton: {
    marginRight: theme.spacing(2),
    [theme.breakpoints.up('sm')]: {
      display: 'none',
    },
  },
  toolbar: theme.mixins.toolbar,
  drawerPaper: {
    width: drawerWidth,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
}));

function ResponsiveDrawer(props) {
  const { container } = props;
  const classes = useStyles();
  const theme = useTheme();
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };
  const ConT =[{name:'About',id:'1',src:'/PersonCenter/about'},
  { name:'Home',id:'2',src:'/PersonCenter/'},
  {name:'Release',id:'3',src:'/PersonCenter/release'}
];

  const drawer = (
    <div>
      <div className={classes.toolbar} >
      <Typography paragraph>
          潇湘药房
        </Typography>
      </div>
      <Divider />
      <List>
          {['first', 'Starred', 'Send email', 'Drafts'].map((text, index) => (
            <ListItem onClick={lClick} button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        {/* mapy映射关系详细 */}
        <List>
          {ConT.map((text) => (
            // <Link key={text.id} to={"/PersonCenter"+text.src}>
            // <ListItem  button  key={text.name} to={text.src}>
            //   <ListItemIcon >{text.id % 2 === 0 ? <InboxIcon /> : <MailIcon />} </ListItemIcon>
            //   <ListItemText  primary={text.src} />
            // </ListItem>
            // </Link>
            <MyCustomLink key={text.name} to={text.src} label={text.name} icon="1" />
          ))}
        </List>
    </div>
  );

  return (
    <div  className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="start"
            onClick={handleDrawerToggle}
            className={classes.menuButton}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            个人中心
          </Typography>
        </Toolbar>
      </AppBar>
      <nav style={{display:'flex'}} className={classes.drawer} aria-label="mailbox folders">
        {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
        <Hidden smUp implementation="css">
          <Drawer
            container={container}
            variant="temporary"
            anchor={theme.direction === 'rtl' ? 'right' : 'left'}
            open={mobileOpen}
            onClose={handleDrawerToggle}
            classes={{
              paper: classes.drawerPaper,
            }}
            ModalProps={{
              keepMounted: true, // Better open performance on mobile.
            }}
          >
            {drawer}
          </Drawer>
        </Hidden>
        <Hidden xsDown implementation="css">
          <Drawer
            classes={{
              paper: classes.drawerPaper,
            }}
            variant="permanent"
            open
          >
            {drawer}
          </Drawer>
        </Hidden>
      </nav>
      <main style={{position:'relative',top:90}} >
      <Switch >                                         {/*单选控制path=*有效*/}
        <Route exact path="/PersonCenter/">
                <App />
        </Route>
        <Route path="/PersonCenter/about">
                <App3 />
        </Route>
        <Route path="/PersonCenter/release">
                <App2/>
        </Route>
        <Route path="*">
              <NoMatch />
        </Route>
      </Switch>
      </main>
    </div>
  );
}

ResponsiveDrawer.propTypes = {
  /**
   * Injected by the documentation to work in an iframe.
   * You won't need it on your project.
   */
  container: PropTypes.instanceOf(typeof Element === 'undefined' ? Object : Element),
};
function lClick(){
    // cPage = coponent;
    console.log("coponent");
  }
  function MyCustomLink({ label,icon,key, to, activeOnlyWhenExact }) {
    var iii=null;

    if(icon==="1"){
      iii=<InboxIcon/>
      activeOnlyWhenExact=true;
    }else{
      iii=<MailIcon/>
    }

    let match = useRouteMatch({
      path: to,
      exact: activeOnlyWhenExact,
      
    });
    
    return (
      <div key={key} style={{display:"flex"}} className={match ? "active" : ""}>
        {match && <ChevronRightOutlinedIcon style={{position:'relative',top:15}}/>}
        <Link to={to} style={{width:200}}>
             <ListItem  button  key={key} >
              {iii}
              <ListItemText style={{marginLeft:38}} primary={label} />
             </ListItem>
          </Link>
      </div>
    );
  }
  function NoMatch() {
    let location = useLocation();
  
    return (
      <div>
        <h3>
          No match for <code>{location.pathname}</code>
        </h3>
      </div>
    );
  }
export default ResponsiveDrawer;