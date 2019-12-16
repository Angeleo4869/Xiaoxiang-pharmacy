import React from 'react';
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
//商品详情接口入口
import Rotate from './rotate';
import Norms from './norms';
import Tabs from './Tabs';

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

export default function SimpleContainer() {
    const classes = useStyles();
    let query = useQuery();
  return (
    <React.Fragment>
      <CssBaseline />
      <Container maxWidth="lg">
        <List style={{display:'flex'}}>
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
        <Fab variant="extended" aria-label="like" className={classes.fab}>
            <PersonIcon className={classes.extendedIcon}/>
            {/* <NavigationIcon className={classes.extendedIcon} /> */}
            lOGIN{query.get("name")}{query.get("age")}
        </Fab>
        </List>
        <Divider style={{marginTop:30,light:true,}}/>
        <div className={classes.flexornot}>
          <Box borderColor="primary.main"  {...boxProps}>
            <ListItem key='1' style={{marginBottom:50,marginRight:10}} >
              <Rotate />
            </ListItem>
          </Box>
          <ListItem key='2'><Norms/></ListItem>  
        </div>
        <Box><Tabs/></Box>
      </Container>
    </React.Fragment>
  );
}