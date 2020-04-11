/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/11
 */
public class LC_119_Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for(int i = 1; i<=rowIndex;i++){
            for(int j = i-1;j>=1;j--){
                int tmp = ret.get(j-1)+ret.get(j);
                ret.set(j,tmp);
            }
        }
        return ret;
    }














}