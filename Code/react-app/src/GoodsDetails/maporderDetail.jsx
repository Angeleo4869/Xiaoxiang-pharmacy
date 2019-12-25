import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import PhoneIcon from '@material-ui/icons/Phone';
import { Link, Hidden } from '@material-ui/core';
import { useEffect } from 'react';
const useStyles = makeStyles(theme => ({
    divpaper:{
        position:'relative',
        width:`calc(100vw - 200px)`,
        height:250,
        marginTop:10,
        [theme.breakpoints.down('xs')]: {
            height:150,
            width:'100%',
          },
    },
    div1:{
        display:'none',
      [theme.breakpoints.down('sm')]: {
        display:'inline',
      },
    },
    div2:{
        
        display:'inline',
      [theme.breakpoints.down('sm')]: {
        display:'none',
      },
    },
    divSmall:{
        display:'flex',
        position:'relative',
        width:'100%',
      },
      divSmall1:{
        display:'flex',
        height:200,
        position:'relative',
        width:'100%',
      },
      divSmall11:{
        display:'flex',
        height:100,
        position:'relative',
        width:'100%',
      },
      divSmall2:{
        display:'flex',
        height:200,
        width:'25%',
      },
      divSmall12:{
        height:100,
        width:'25%',
      },
      divImg:{
        display:'flex',
          height:200,
          position:'relative',
          width:'100%',
      },
      divImg1:{
        display:'flex',
          height:100,
          position:'relative',
          width:'100%',
      },
    divBig:{
        position:'relative',
        width:'100%',
      },
      divSpan:{
          wordWrap:'break-word',
          wordBreak:'break-all',
          width:400,
          height:200,
    },
    divSpan1:{
        wordWrap:'break-word',
        wordBreak:'break-all',
        width:200,
        height:50,
  },
    divSpecifications:{
        marginLeft:'10%',
        display:'flex',
        height:200,
        width:'25%',
    },
    divSpecificationsa:{
        marginLeft:'10%',
        display:'flex',
        height:100,
        width:'25%',
    },
    divSpecifications1:{
        display:'flex',
        height:50,
    },
    divSpecifications2:{
        width:25,
        height:50,
        float:'right',
    },
    divSpecifications3:{
        display:'flex',
        height:50,
        float:'right',
        marginRight:'5%',
    },
    divSpecifications4:{
        display:'flex',
        float:'right',
        marginRight:'5%',
    },
    divright:{
        float:'right',
        display:'flex',
        marginRight:'5%',
    },
    divright1:{
        display:'inline',
        height:100,
        float:'right',
        marginRight:'5%',
    },
    dibflex:{
        display:'flex',
    }
  }));
const Welcome21 = props =>{
    const eventContent =[
        {name:'第一个药店',states:'状态emmmm',label:'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX',Specifications:'10*10',money:'￥:44444',numbers:'5',total:'￥:4444'},
        ]
        console.log(props.content.id)
        // const Data = React.useState(props.content) 
        const classes = useStyles();
        // console.log(props.content)
        return(
          <Paper className={classes.divpaper}>
              {/* 小 */}
              <div className={classes.div1}>
              {eventContent.map((text,index)=>(
                <div key={index} className={classes.divBig}>
                <div className={classes.divBig}>
                    <div className={classes.divSmall}>
                        <div className={classes.divSmall}>
                            <Typography noWrap><PhoneIcon fontSize='small'/>丨</Typography>&nbsp;<Link to="" ><Typography noWrap>{props.content.id.storename}</Typography></Link>
                        </div>
                        <div className={classes.divright}>
                        <Link to="" ><Typography noWrap>{props.content.id.odstate}</Typography></Link>
                        </div>     
                    </div>
                    <div className={classes.divSmall11}>
                        <div className={classes.divSmall12}>
                            <Typography noWrap className={classes.divImg}><img className={classes.divImg1} alt="complex" src="/Pic/yao1.png" /></Typography>
                        </div>
                        <div className={classes.divSmall12}>
                            <span className={classes.divSpan1}>           
                            {props.content.id.shname}
                            </span>
                            <div className={classes.divSpecifications1}>                             
                                {/* {Data.Specifications}     */}
                                10*10
                            </div>
                        </div>
                        <div className={classes.divSpecificationsa}>                             
                                   
                        </div>
                        <div className={classes.divright1}> 
                                <div className={classes.divSpecifications2}>
                                    {props.content.id.shPrice}
                                </div>                            
                                <div className={classes.divSpecifications2}>                             
                                    X{props.content.id.odNumber}    
                                </div>
                                
                        </div>
                    </div>
                </div>
                <div className={classes.divBig}>
                    <div className={classes.divSpecifications4}>                             
                                共{props.content.id.odNumber}件商品，合计{props.content.id.shPrice*props.content.id.odNumber}   
                    </div>
                </div>
                </div>
            ))}
              </div>
            <Hidden smDown>
                <Paper style={{display:'flex',marginTop:5}} >
                    <span style={{width:'50%'}}>
                        <center>
                        商品信息
                        </center>
                    </span>
                    <span style={{width:'25%'}}>
                        <center>
                        规格
                        </center>
                    </span>
                    <span style={{width:'25%'}}>
                        <center>
                        价格
                        </center>
                    </span>
                </Paper>
            </Hidden>

              {/* 大 */}
              <div className={classes.div2}>
              {eventContent.map((text,index)=>(
                <div key={index} className={classes.divBig}>
                    <div className={classes.divSmall}>
                        <div className={classes.divSmall}>
                            <Typography noWrap><PhoneIcon fontSize='small'/>丨</Typography>&nbsp;<Link to="" ><Typography noWrap>{props.content.id.storename}</Typography></Link>
                        </div>
                        <div className={classes.divright}>
                        <Link to="" ><Typography noWrap>{props.content.id.odstate}</Typography></Link>
                        </div>     
                    </div>
                    <div className={classes.divSmall1}>
                        <div className={classes.divSmall2}>
                            <Typography noWrap className={classes.divImg}><img className={classes.divImg} alt="complex" src="/Pic/yao1.png" /></Typography>
                        </div>
                        <div className={classes.divSmall2}>
                            <span className={classes.divSpan} style={{marginTop:`100px`}}>           
                            {props.content.id.shname}
                            </span>
                        </div>
                        <div className={classes.divSpecifications}>                             
                                {/* {text.Specifications}     */}
                                <span style={{marginTop:`100px`}}>
                                10*10
                                </span>
                        </div>
                        <div className={classes.divright}>   
                            <span style={{height:'100%',marginTop:`100px`}}>                          
                                {props.content.id.shPrice}  
                            </span>
                        </div>
                    </div>
                </div>
            ))}
              </div>
             
          </Paper>
        );
  }
export default Welcome21;