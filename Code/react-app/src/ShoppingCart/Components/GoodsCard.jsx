import React from 'react';
// import { fontSize } from '@material-ui/system';
// import { height } from '@material-ui/system';
// import { thisExpression } from '@babel/types';


export default class GoodsCard extends React.Component{
    constructor(props){
        super(props)
        this.state={name:'阿莫西林胶囊'}
    }

    render(){
        return(
            <div>
                <span>
                <img style={{width:'70px', height:'50px',float:'left', marginRight:'10px'}} alt="images" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574265712455&di=b3bfe17e832f8b6a91d7b751f534e9a9&imgtype=0&src=http%3A%2F%2Fimg.jianke.com%2Fupload%2Fprodimage%2F201511%2F201511216454198.jpg"/>
                </span>
                <p style={{width:'140px', height:'50px', lineHeight:'50px',overflow:'hidden', fontSize:'14px'}}>{this.state.name}</p>
            </div>
        );
    }

}

