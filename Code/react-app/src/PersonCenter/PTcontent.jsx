import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Avatar from '@material-ui/core/Avatar';
import Divider from '@material-ui/core/Divider';
import { List } from '@material-ui/core';
import Hidden from '@material-ui/core/Hidden';
import Paper from '@material-ui/core/Paper';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';

import PTCard from './PTcontentCard.jsx';

const useStyles = makeStyles({
  card: {
    minWidth: 250 ,
    minHeight:150,
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    fontSize: 14,
  },
  pos: {
    marginBottom: 12,
  },
  gridroot: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
  },
});

export default function SimpleCard() {
  const classes = useStyles();
  // const bull = <span className={classes.bullet}>•</span>;
  // const decide = 0;
  return (
  <div style={{position:'relative',left:0,width:'100%'}}>
    <Card className={classes.card}>
      <CardContent>
      <List horizontal="true" style={{display:'flex',justifyContent:'space-around',backgroundColor:'#EFFEFE'}}>
        <Avatar alt="not" src="/Pic/D1.jpg"  />                
        <div style={{position:'relative',left:0}}>Your name</div>
        <Typography className={classes.title} color="textSecondary" gutterBottom>收货地址</Typography>
        <Typography className={classes.title} color="textSecondary" gutterBottom>优惠信息</Typography>
        <Typography className={classes.title} color="textSecondary" gutterBottom>会员信息</Typography>              
        </List>
        <Divider style={{position:'relative',top:10}} />
        <List  horizontal="true" style={{display:'flex',justifyContent:'space-around',top:20,bottom:-1}}  >
        <Typography key="t1"  color="textSecondary" gutterBottom>待付款<span>1</span></Typography>
        <Divider component="li" />
        <Typography key="t3" color="textSecondary" gutterBottom>待发货</Typography>
        <Divider key="t4" orientation="vertical" />
        <Typography key="t5" color="textSecondary" gutterBottom>待收货</Typography>
        <Divider key="t6" orientation="vertical" />
        <Typography key="t7" color="textSecondary" gutterBottom>待评价</Typography>
        <Divider key="t8" orientation="vertical" />
        <Typography key="t9"  color="textSecondary" gutterBottom>退款</Typography>
        </List>
      </CardContent>
      <CardActions>
        {/* <Button size="small">Learn More</Button> */}
      </CardActions>
    </Card>
    <Paper style={{top:30,position:'relative',width:'100%'}} className={classes.card}>
        <div horizontal="true"  style={{display:'flex',backgroundColor:"#EFFEFE",height:50,width:'100%'}}>
             <List  horizontal="true"  style={{display:'flex',width:'100%'}} > 
                <Typography variant="h5"  style={{position:'relative',top:0,left:10,width:350}} >推荐</Typography>
                <Button style={{position:'absolute',top:10,height:30,right:5,color:'',backgroundColor:'#6495ED'}}>换一下</Button>
            </List>
            
        </div>
<div className={classes.gridroot}>
  <nav style={{display:'flex'}} className={classes.drawer} aria-label="mailbox folders">
  <Hidden smUp implementation="css">
<GridList cellHeight={300}  cols={2}>
        {['hello','the','mad','twhe','mawd','thfe','mafd','thce','mcad'].map((text,index) => (
          <GridListTile key={text} >
            <PTCard  key={index} size={1} name={text}/>
          </GridListTile>
        ))}
</GridList>
  </Hidden>
  <Hidden xsDown implementation="css">
  <GridList cellHeight={330}  cols={4}>
        {['hhello','the','mad','twhe','mawd','thfe','mafd','thce','mcad'].map((text,index) => (
          <GridListTile key={text} >
            <PTCard key={index} size={2} name={text}/>
          </GridListTile>
        ))}
</GridList>

  </Hidden>
</nav>
<div style={{height:95}}>s</div>
</div> 
    </Paper>
    
  </div>
  );
}