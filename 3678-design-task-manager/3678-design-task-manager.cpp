class TaskManager {
public:
    set<pair<int,pair<int,int>>>st;
    //priority , taskid , userid
    map<int,pair<int,int>>mp;
     //taskid - priority,userid
    TaskManager(vector<vector<int>>& tasks) {
        for(auto i: tasks){
            st.insert({i[2],{i[1],i[0]}});
            mp[i[1]]={i[2],i[0]};
        }
    }
    
    void add(int userId, int taskId, int priority) {
        st.insert({priority,{taskId,userId}});
        mp[taskId] = {priority, userId};
    }
    
    void edit(int taskId, int newPriority) {
        st.erase({mp[taskId].first,{taskId,mp[taskId].second}});
        st.insert({newPriority,{taskId,mp[taskId].second}});
        mp[taskId].first=newPriority;
    }
    
    void rmv(int taskId) {
        st.erase({mp[taskId].first,{taskId,mp[taskId].second}});
        mp.erase(taskId);
    }
    
    int execTop() {
        if (st.empty()) return -1;
        auto top = *st.rbegin(); // Access the last element in the set
        st.erase(top); // Remove the top element
        mp.erase(top.second.first); // Remove from the map
        return top.second.second; // Return the userid
    }
};

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager* obj = new TaskManager(tasks);
 * obj->add(userId,taskId,priority);
 * obj->edit(taskId,newPriority);
 * obj->rmv(taskId);
 * int param_4 = obj->execTop();
 */