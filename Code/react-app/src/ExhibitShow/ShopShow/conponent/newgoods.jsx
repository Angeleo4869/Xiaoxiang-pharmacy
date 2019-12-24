import React from 'react';
import GridList from '@material-ui/core/GridList';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import GridListTile from '@material-ui/core/GridListTile';
import Hidden from '@material-ui/core/Hidden';
//import image from '/picture/David.jpg';
const useStyles = makeStyles(theme=>({
  root: {
    width:'100%',
    overflowX:'hidden',
    // [theme.breakpoints.down('xs')]: {
    //   display:'inline',
    //   width:400,
    // }
  },
  image: {
    width:220,
    height:'auto',
    [theme.breakpoints.down('xs')]: {
      width:`calc(40vw)`,
      height:'auto',
    }
  },
  card: {
    // Width: 400,
  },
  media: {
    // height: 140,
  },
}));

const Goods=[
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿莫西林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'},
  {picture:'/Pic/yao.jpg',name:'阿司匹林',price:'$19.9'}];

export default function MediaCard() {
  const classes = useStyles();

  return (
    <div className={classes.root} >
      <Hidden  smUp>
        <GridList cellHeight={300} cols={2}>
        {Goods.map((text)=>(
          <GridListTile key="Subheader">
            <div style={{display:'flex'}} >
              <Card className={classes.card}>
              <CardContent>
                <img className={classes.image}  src={text.picture} />
                <br/>
              </CardContent>
              <CardActions>
                <Typography style={{display:'flex'}}>
                  {text.name}
                  <br/>
                  {text.price}
                </Typography>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <Button size="small" variant="contained" color="secondary">
                  查看详情
                </Button>
              </CardActions>
          </Card>
            
            </div>
          </GridListTile>
        ))}
        </GridList>
      </Hidden>
      <Hidden xsDown>
        <GridList cellHeight={400} cols={4}>
          {Goods.map((text)=>(
            <GridListTile key="Subheader">
              <div style={{display:'flex'}} >
                <Card className={classes.card}>
                <CardContent>
                  <img className={classes.image}  src={text.picture} />
                  <br/>
                </CardContent>
                <CardActions>
                  <Typography style={{display:'flex'}}>
                    {text.name}
                    <br/>
                    {text.price}
                  </Typography>
                  
                  <Button size="small" variant="contained" color="secondary" style={{position:'absolute',right:`calc(6vw - 10px)`}}>
                    查看详情
                  </Button>
                </CardActions>
              </Card>
              </div>
            </GridListTile>
          ))}
        </GridList>
      </Hidden>
    </div>
  );
}