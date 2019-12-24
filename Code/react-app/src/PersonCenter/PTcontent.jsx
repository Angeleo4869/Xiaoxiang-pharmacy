import React,{useEffect} from 'react';
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

import {
  Route,
  Link,
  Switch,
  useRouteMatch,
  useLocation
} from 'react-router-dom';

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

const Cont = [
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'},
{id:'1',name:'伸腿瞪眼丸',price:'120',imagesrc:'/Pic/D1.jpg'}
]
export default function SimpleCard(props) {
  const classes = useStyles(); 
  if(props.data.buyerName===null){
    props.data.buyerName="陌生人"
  }
  // console.log(props.data)
  // const bull = <span className={classes.bullet}>•</span>;
  // const decide = 0;
  return (
  <div style={{position:'relative',left:0,width:'100%'}}>
    <Card className={classes.card}>
      <CardContent>
      <List horizontal="true" style={{display:'flex',justifyContent:'space-around',backgroundColor:'#EFFEFE'}}>
        <Avatar alt="not" src="/Pic/D1.jpg"  />                
        <div style={{position:'relative',left:0}}>{props.data.buyerName}</div>
        <Link to="/PersonCenter/show/address"><Typography className={classes.title} color="textSecondary" gutterBottom>收货地址</Typography></Link>
        <Typography className={classes.title} color="textSecondary" gutterBottom>优惠信息</Typography>
        <Typography className={classes.title} color="textSecondary" gutterBottom>会员信息</Typography>              
        </List>
        <Divider style={{position:'relative',top:10}} />
        <List  horizontal="true" style={{display:'flex',justifyContent:'space-around',top:20,bottom:-1}}  >
        <Link to="/PersonCenter/order?tab=0"><Typography key="t1"  color="textSecondary" gutterBottom>待付款<span>1</span></Typography></Link>
        <Divider component="li" />
        <Link to="/PersonCenter/order?tab=1"><Typography key="t3" color="textSecondary" gutterBottom>待发货</Typography></Link>
        <Divider key="t4" orientation="vertical" />
        <Link to="/PersonCenter/order?tab=2"><Typography key="t5" color="textSecondary" gutterBottom>待收货</Typography></Link>
        <Divider key="t6" orientation="vertical" />
        <Link to="/PersonCenter/order?tab=3"><Typography key="t7" color="textSecondary" gutterBottom>待评价</Typography></Link>
        <Divider key="t8" orientation="vertical" />
        <Link to="/PersonCenter/order?tab=4"><Typography key="t9"  color="textSecondary" gutterBottom>退款</Typography></Link>
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
          <Hidden xsDown implementation="css">
            <GridList cellHeight={330}  cols={4}>
                  {Cont.map((text,index) => (
                    <GridListTile key={index} >
                      <PTCard  size={2} id={text.id} name={text.name} price={text.price} imagesrc={text.imagesrc} />
                    </GridListTile>
                  ))}
            </GridList>
          </Hidden>
          <Hidden smUp implementation="css">
            <GridList cellHeight={300}  cols={2}>
                    {Cont.map((text,index) => (
                      <GridListTile key={index} >
                        <PTCard   size={1} id={text.id} name={text.name} price={text.price} imagesrc={text.imagesrc}/>
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