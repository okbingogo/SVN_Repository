/*
Navicat SQL Server Data Transfer

Source Server         : MSSQL_LOCAL_SQLEXPRESS
Source Server Version : 105000
Source Host           : (local)\SQLEXPRESS:1433
Source Database       : msg_board_db
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2016-07-16 17:47:04
*/


-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE [dbo].[t_comment]
GO
CREATE TABLE [dbo].[t_comment] (
[comm_id] int NOT NULL IDENTITY(1,1) ,
[from_name] nvarchar(16) NOT NULL ,
[msg_id] int NOT NULL ,
[comm_content] nvarchar(200) NOT NULL ,
[comm_time] datetime NOT NULL DEFAULT (getdate()) 
)


GO

-- ----------------------------
-- Records of t_comment
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_comment] ON
GO
INSERT INTO [dbo].[t_comment] ([comm_id], [from_name], [msg_id], [comm_content], [comm_time]) VALUES (N'1', N'aa', N'3', N'士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大范围全额投入bc士大夫撒旦发生大', N'2016-07-15 09:12:58.863')
GO
GO
SET IDENTITY_INSERT [dbo].[t_comment] OFF
GO

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE [dbo].[t_message]
GO
CREATE TABLE [dbo].[t_message] (
[msg_id] int NOT NULL IDENTITY(1,1) ,
[from_name] nvarchar(16) NOT NULL ,
[msg_content] nvarchar(200) NOT NULL ,
[msg_time] datetime NOT NULL DEFAULT (getdate()) 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_message]', RESEED, 14)
GO

-- ----------------------------
-- Records of t_message
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_message] ON
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'1', N'aa', N'阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的', N'2016-07-15 09:05:04.173')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'2', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:16.090')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'3', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:17.540')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'4', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:18.810')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'5', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:20.060')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'6', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:21.420')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'7', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:22.757')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'8', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:24.073')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'9', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-14 09:05:25.390')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'10', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:26.650')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'11', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-14 09:05:27.917')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'12', N'aa', N'
 发布
#1
test1
阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯蒂芬撒发生的事发生的阿斯', N'2016-07-15 09:05:29.323')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'13', N'aa', N'sadfsfsd', N'2016-07-15 09:12:46.390')
GO
GO
INSERT INTO [dbo].[t_message] ([msg_id], [from_name], [msg_content], [msg_time]) VALUES (N'14', N'aa', N'哦', N'2016-07-14 09:13:32.493')
GO
GO
SET IDENTITY_INSERT [dbo].[t_message] OFF
GO

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE [dbo].[t_user]
GO
CREATE TABLE [dbo].[t_user] (
[user_id] int NOT NULL IDENTITY(1,1) ,
[username] nvarchar(16) NOT NULL ,
[password] varchar(16) NOT NULL ,
[email] varchar(32) NOT NULL ,
[reg_time] datetime NOT NULL DEFAULT (getdate()) 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_user]', RESEED, 9)
GO

-- ----------------------------
-- Records of t_user
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_user] ON
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'1', N'aa', N'aa', N'aa', N'2016-07-14 11:29:38.923')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'2', N'bb', N'bb', N'bb', N'2016-07-14 11:29:47.060')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'3', N'cc', N'cc', N'cc', N'2016-07-14 11:29:52.517')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'5', N's', N's', N's', N'2016-07-14 16:34:08.393')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'7', N'a', N'a', N'asdfsadf@qq', N'2016-07-14 16:41:13.000')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'8', N'b', N'b', N'b', N'2016-07-14 16:48:00.553')
GO
GO
INSERT INTO [dbo].[t_user] ([user_id], [username], [password], [email], [reg_time]) VALUES (N'9', N'test1', N'test1', N'test1@qq.com', N'2016-07-15 09:03:18.940')
GO
GO
SET IDENTITY_INSERT [dbo].[t_user] OFF
GO

-- ----------------------------
-- View structure for all
-- ----------------------------
DROP VIEW [dbo].[all]
GO
CREATE VIEW [dbo].[all] AS 
SELECT
	dbo.t_user.user_id,
	dbo.t_user.username,
	dbo.t_message.msg_id,
	dbo.t_message.msg_content,
	dbo.t_message.msg_time,
	dbo.t_comment.comm_id,
	dbo.t_comment.comm_content,
	dbo.t_comment.comm_time

FROM
dbo.t_user
LEFT JOIN dbo.t_message ON dbo.t_message.user_id = dbo.t_user.user_id
LEFT JOIN dbo.t_comment ON dbo.t_comment.msg_id = dbo.t_message.msg_id AND dbo.t_comment.user_id = dbo.t_user.user_id
GO

-- ----------------------------
-- Indexes structure for table t_comment
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_comment
-- ----------------------------
ALTER TABLE [dbo].[t_comment] ADD PRIMARY KEY ([comm_id])
GO

-- ----------------------------
-- Indexes structure for table t_message
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_message
-- ----------------------------
ALTER TABLE [dbo].[t_message] ADD PRIMARY KEY ([msg_id])
GO

-- ----------------------------
-- Indexes structure for table t_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE [dbo].[t_user] ADD PRIMARY KEY ([user_id])
GO
