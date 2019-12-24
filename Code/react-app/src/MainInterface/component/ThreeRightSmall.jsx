import React from 'react';
import { Link } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Center from 'react-center';
const defaultProps = {
    bgcolor: 'background.paper',
    // m: 1,
    border: 1,
  };
  
const useStyles = makeStyles(theme => ({
    divBig:{
        position:'relative',
        width:'100%',
        height:400,
    },
    div:{
        position:'relative',
        width:'60%',
        height:200,
        marginTop:40,
    },
    div1:{
        position:'relative',
        width:'100%',
        height:200,
    },
    divs:{
        position:'relative',
        width:'40%',
        height:200,
        marginTop:40,
    },
    divs1:{
        position:'relative',
        width:'100%',
        height:200,
    },
    divBox:{
        position:'relative',
        width:'100%',
        height:200,
    },
    divBox1:{
        width:'100%',
        height:125,
    },
    dd:{
        marginTop:'5%',
    },
    ddd:{
        position:'relative',
        width:'100%',
        display:'flex',
        height:240,
    },
    dddd:{
        position:'relative',
        width:'100%',
        display:'flex',
        height:180,
    },
    link:{
        color:'#ff0000',
    }
}));

const link5={
    color:'#000000',
}
export default function Test(props){
    
    const classes = useStyles();
    const [All,setAll] = React.useState(props.name
    );
    const [Links1,setLinks1] = React.useState(link5);
    const [Links2,setLinks2] = React.useState(link5);
    const [Links3,setLinks3] = React.useState(link5);
    const Links6 = {color:'#FF0000'};
    const eventContent =[
        {id:Links1,mr:()=>(setLinks1(Links6)),mt:()=>(setLinks1(link5))},
        {id:Links2,mr:()=>(setLinks2(Links6)),mt:()=>(setLinks2(link5))},
        {id:Links3,mr:()=>(setLinks3(Links6)),mt:()=>(setLinks3(link5))}
    ]
    return(
        <div className={classes.divBig}>
            <div className={classes.ddd}>
            
            {All[0].contSAT.map((text,index)=>(
                <div className={classes.div} key={index}>
                    <Link to={text.to}><img alt="loading" className={classes.div1} src={text.imgsrc}/></Link>
                </div>
                ))}
                
                {All[0].contSAA.map((text,index)=>(
                    <div className={classes.divs} key={index}>
                        <Link to={text.to}><img alt="loading" className={classes.divs1} src={text.imgsrc}/></Link>
                    </div>
                ))}
            </div>
            <div className={classes.dddd}>
                {eventContent.map((text,index)=>(
                    <Box key={index} className={classes.divBox} borderColor="#DDDDDD" {...defaultProps}>
                         <Center>
                             <Link to={All[0].contaA[index].to}><img alt="loading" className={classes.divBox1} src={All[0].contaA[index].imgsrc}/></Link>   
                         </Center>
                         <div >
                            <Center>
                                <Link style={text.id} to={All[0].contaA[index].to}><Typography noWrap >{All[0].contaA[index].label}</Typography></Link>
                            </Center>
                         </div>
                         <div className={classes.dd}>
                            <Center>
                                <Typography noWrap className={classes.link}>{All[0].contaA[index].money}</Typography>
                            </Center>
                         </div>
                    </Box>
                ))}
                
            </div>
           
        </div>
    );
  }
