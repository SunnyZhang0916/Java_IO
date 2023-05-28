# Java_IO
file.exists());   //判断此File的实例对应的文件是否存在
file.isFile());       //判断此File实例是否是一个标准的文件
file.isDirectory());//判断此File实例是否是一个文件夹
file.getName());     //获取此File实例对应的文件或文件夹的名称
file.getAbsolutePath());     //获取此File实例对应文件或文件夹的绝对路径
new Date(file.lastModified()).toLocaleString());     //返回此File实例的最后修改时间

创建文件
file.createNewFile()
创建文件夹
file.mkdir(); 

删除文件
file.delete();          //立即删除文件或目录
file.deleteOnExit();    //在程序/进程结束的时候，将文件删除。也就是无法立刻写create file
